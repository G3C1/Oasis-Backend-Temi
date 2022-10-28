package com.g3c1.temi.domain.purchase.service.impl;

import com.g3c1.temi.domain.food.utils.FoodUtils;
import com.g3c1.temi.domain.purchase.domain.entity.Purchase;
import com.g3c1.temi.domain.purchase.domain.repository.PurchaseRepository;
import com.g3c1.temi.domain.purchase.presentation.dto.request.PurchasedFoodRequest;
import com.g3c1.temi.domain.purchase.presentation.dto.response.PurchasedFoodListResponse;
import com.g3c1.temi.domain.purchase.service.PurchaseService;
import com.g3c1.temi.domain.seat.domain.entity.Seat;
import com.g3c1.temi.domain.seat.utils.SeatUtils;
import com.g3c1.temi.domain.seat.utils.SeatValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final SeatUtils seatUtils;
    private final SeatValidator seatValidator;
    private final FoodUtils foodUtils;

    @Transactional(rollbackFor = Exception.class,readOnly = true)
    @Override
    public List<PurchasedFoodListResponse> getPurchaseFoodInfo() {
        List<Purchase> purchaseList = purchaseRepository.findAll();
        List<Seat> seatIdList = getSeatIdList(purchaseList);
        return seatIdList.stream().map(seat -> PurchasedFoodListResponse.builder()
                .seatNumber(seat.getSeatNumber())
                .foodInfoList(getFoodInfoList(seat))
                .build())
                .collect(Collectors.toList());
    }
    private List<PurchasedFoodListResponse.FoodInfo> getFoodInfoList(Seat seat) {
        return purchaseRepository.findPurchaseBySeat(seat).stream().map(purchase -> PurchasedFoodListResponse.FoodInfo.builder()
                .foodName(purchase.getFood().getName())
                .foodCount(purchase.getFoodCount())
                .build()).collect(Collectors.toList());
    }
    private List<Seat> getSeatIdList(List<Purchase> purchaseList) {
        List<Seat> seatList = new ArrayList<>();
        purchaseList.forEach(purchase -> {
            if (!seatList.equals(purchase.getSeat())) seatList.add(purchase.getSeat());
        });
        return seatList.stream().distinct().collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addPurchasedFood(PurchasedFoodRequest purchaseFoodRequest) {
        Seat seatInfo = seatUtils.getSeatInfo(purchaseFoodRequest.getSeatId());
        seatValidator.checkSeatIsNotUsed(seatInfo);
        saveAllFoodList(purchaseFoodRequest.getFoodLists(),seatInfo);
    }
    private void saveAllFoodList(List<PurchasedFoodRequest.PurchaseFoodList>foodInfoList, Seat seatInfo){
        purchaseRepository.saveAll(foodInfoList.stream()
                .map(foodInfo -> new Purchase(seatInfo,foodUtils.findFoodInfoById(foodInfo.getFoodId()),foodInfo.getFoodCount()))
                .collect(Collectors.toList()));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removePurchasedFood(Long seatId) {
        purchaseRepository.deleteBySeat(seatUtils.getSeatInfo(seatId));
    }
}
