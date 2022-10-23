package com.g3c1.temi.domain.purchase.service;

import com.g3c1.temi.domain.purchase.presentation.dto.response.PurchaseFoodListResponse;

import java.util.List;

public interface GetPurchaseFoodListService {
    List<PurchaseFoodListResponse> execute();
}
