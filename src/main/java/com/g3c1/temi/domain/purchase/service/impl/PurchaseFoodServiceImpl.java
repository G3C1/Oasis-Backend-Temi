package com.g3c1.temi.domain.purchase.service.impl;

import com.g3c1.temi.domain.food.entity.Food;
import com.g3c1.temi.domain.food.repository.FoodRepository;
import com.g3c1.temi.domain.purchase.entity.Purchase;
import com.g3c1.temi.domain.purchase.repository.PurchaseRepository;
import com.g3c1.temi.domain.purchase.exception.FoodNotFoundException;
import com.g3c1.temi.domain.purchase.presentation.dto.request.PurchaseFoodRequest;
import com.g3c1.temi.domain.purchase.service.PurchaseFoodService;
import com.g3c1.temi.domain.seat.entity.Seat;
import com.g3c1.temi.domain.seat.utils.SeatUtils;
import com.g3c1.temi.domain.seat.utils.SeatValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseFoodServiceImpl implements PurchaseFoodService{
    private final PurchaseRepository purchaseRepository;
    private final FoodRepository foodRepository;
    private final SeatUtils seatUtils;
    private final SeatValidator seatValidator;

    @Transactional(rollbackFor = Exception.class)
    public void execute(PurchaseFoodRequest purchaseFoodRequest){
        Seat seatInfo = seatUtils.getSeatInfo(purchaseFoodRequest.getSeatId());
        seatValidator.checkSeatIsNotUsed(seatInfo);
        saveAllFoodList(purchaseFoodRequest.getFoodLists(),seatInfo);
    }
    private Food findFood(Long foodId) {
        return foodRepository.findFoodById(foodId).orElseThrow(() -> new FoodNotFoundException("음식을 찾을 수 없습니다."));
    }
    private static Purchase getPurchase(Seat seatInfo, Food foodInfo,Long foodCount) {
        return new Purchase(foodInfo, seatInfo,foodCount);
    }
    private void saveAllFoodList(List<PurchaseFoodRequest.PurchaseFoodList>foodInfoList, Seat seatInfo){
        purchaseRepository.saveAll(foodInfoList.stream()
                .map(foodInfo -> getPurchase(seatInfo,findFood(foodInfo.getFoodId()),foodInfo.getFoodCount()))
                .collect(Collectors.toList()));
    }
}
