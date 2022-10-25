package com.g3c1.temi.domain.purchase.service.impl;

import com.g3c1.temi.domain.purchase.domain.entity.Purchase;
import com.g3c1.temi.domain.purchase.presentation.dto.response.PurchaseFoodListResponse;
import com.g3c1.temi.domain.purchase.domain.repository.PurchaseRepository;
import com.g3c1.temi.domain.purchase.service.GetPurchaseFoodListService;
import com.g3c1.temi.domain.seat.domain.entity.Seat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetPurchaseFoodListServiceImpl implements GetPurchaseFoodListService {
    private final PurchaseRepository purchaseRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<PurchaseFoodListResponse> execute() {
        List<Purchase> purchaseList = purchaseRepository.findAll();
        List<Seat> seatIdList = getSeatIdList(purchaseList);
        return seatIdList.stream().map(seat -> PurchaseFoodListResponse.builder()
                .seatNumber(seat.getSeatNumber())
                .foodInfoList(purchaseRepository.findPurchaseBySeat(seat).stream().map(purchase -> PurchaseFoodListResponse.FoodInfo.builder()
                        .foodName(purchase.getFood().getName())
                        .foodCount(purchase.getFoodCount())
                        .build()).collect(Collectors.toList()))
                .build()).collect(Collectors.toList());
    }
    private List<Seat> getSeatIdList(List<Purchase> purchaseList){
        List<Seat> seatList = new ArrayList<>();
        purchaseList.stream().forEach(purchase -> {
            if(!seatList.equals(purchase.getSeat())) seatList.add(purchase.getSeat());
        });
        return seatList.stream().distinct().collect(Collectors.toList());
    }
}
