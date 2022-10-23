package com.g3c1.temi.domain.purchase.service;

import com.g3c1.temi.domain.purchase.entity.Purchase;

import java.util.List;

public interface GetPurchaseFoodListService {
    List<Purchase> execute();
}
