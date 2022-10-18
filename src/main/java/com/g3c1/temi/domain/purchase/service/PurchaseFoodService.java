package com.g3c1.temi.domain.purchase.service;

import com.g3c1.temi.domain.food.entity.Food;
import com.g3c1.temi.domain.food.repository.FoodRepository;
import com.g3c1.temi.domain.purchase.entity.Purchase;
import com.g3c1.temi.domain.purchase.presentation.dto.request.PurchaseFoodRequest;
import com.g3c1.temi.domain.purchase.repository.PurchaseRepository;
import com.g3c1.temi.domain.seat.entity.Seat;
import com.g3c1.temi.domain.seat.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseFoodService {
    private final PurchaseRepository purchaseRepository;
    private final SeatRepository seatRepository;
    private final FoodRepository foodRepository;

    public void execute(PurchaseFoodRequest purchaseFoodRequest){
        Seat seatInfo = seatRepository.findSeatById(purchaseFoodRequest.getSeatId()).orElseThrow();
        purchaseRepository.saveAll(purchaseFoodRequest.getFoodIdList().stream()
                .map(food -> foodRepository.findFoodById(food).orElseThrow())
                .map(foodInfo -> getPurchase(seatInfo, foodInfo)).collect(Collectors.toList()));
    }
    private static Purchase getPurchase(Seat seatInfo, Food foodInfo) {
        return new Purchase(foodInfo, seatInfo);
    }
}
