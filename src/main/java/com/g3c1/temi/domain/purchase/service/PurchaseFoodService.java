package com.g3c1.temi.domain.purchase.service;

import com.g3c1.temi.domain.purchase.presentation.dto.request.PurchaseFoodRequest;

public interface PurchaseFoodService {
    void execute(PurchaseFoodRequest purchaseFoodRequest);
}
