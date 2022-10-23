package com.g3c1.temi.domain.purchase.service.impl;

import com.g3c1.temi.domain.purchase.entity.Purchase;
import com.g3c1.temi.domain.purchase.repository.PurchaseRepository;
import com.g3c1.temi.domain.purchase.service.GetPurchaseFoodListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPurchaseFoodListServiceImpl implements GetPurchaseFoodListService {
    private final PurchaseRepository purchaseRepository;


    @Override
    public List<Purchase> execute() {
        List<Purchase> purchaseList = purchaseRepository.findAll();
    }
}
