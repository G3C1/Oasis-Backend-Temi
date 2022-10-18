package com.g3c1.temi.domain.purchase.presentation;

import com.g3c1.temi.domain.purchase.presentation.dto.request.PurchaseFoodRequest;
import com.g3c1.temi.domain.purchase.service.PurchaseFoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("purchase")
public class PurchaseController {
    private final PurchaseFoodService purchasefoodService;
    @PostMapping
    public ResponseEntity<Void> purchaseFood(@RequestBody PurchaseFoodRequest purchaseFoodRequest){
        purchasefoodService.execute(purchaseFoodRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
