package com.g3c1.temi.domain.purchase.service;

import com.g3c1.temi.domain.purchase.presentation.dto.request.PurchasedFoodRequest;
import com.g3c1.temi.domain.purchase.presentation.dto.response.PurchasedFoodListResponse;

import java.util.List;

public interface PurchaseService {
    List<PurchasedFoodListResponse> getPurchaseFoodInfo();
    void addPurchasedFood(PurchasedFoodRequest purchaseFoodRequest);
    void removePurchasedFood(Long seatId);
}
