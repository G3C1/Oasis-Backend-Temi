package com.g3c1.temi.domain.purchase.service;

import com.g3c1.temi.domain.food.entity.Food;
import com.g3c1.temi.domain.food.repository.FoodRepository;
import com.g3c1.temi.domain.purchase.entity.Purchase;
import com.g3c1.temi.domain.purchase.exception.FoodNotFoundException;
import com.g3c1.temi.domain.purchase.presentation.dto.request.PurchaseFoodRequest;
import com.g3c1.temi.domain.purchase.repository.PurchaseRepository;
import com.g3c1.temi.domain.seat.entity.Seat;
import com.g3c1.temi.domain.seat.repository.SeatRepository;
import com.g3c1.temi.domain.seat.utils.SeatUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseFoodService {
    private final PurchaseRepository purchaseRepository;
    private final FoodRepository foodRepository;
    private final SeatUtils seatUtils;

    public void execute(PurchaseFoodRequest purchaseFoodRequest){
        Seat seatInfo = seatUtils.getSeatInfo(purchaseFoodRequest.getSeatId());
        saveAllFoodList(purchaseFoodRequest.getFoodIdList(),seatInfo);
    }
    private Food findFood(Long foodId) {
        return foodRepository.findFoodById(foodId).orElseThrow(() -> new FoodNotFoundException("음식을 찾을 수 없습니다."));
    }
    private static Purchase getPurchase(Seat seatInfo, Food foodInfo) {
        return new Purchase(foodInfo, seatInfo);
    }
    private void saveAllFoodList(List<Long>foodIdList,Seat seatInfo){
        purchaseRepository.saveAll(foodIdList.stream()
                .map(this::findFood)
                .map(foodInfo -> getPurchase(seatInfo, foodInfo))
                .collect(Collectors.toList()));
    }
}
