package com.g3c1.temi.domain.purchase.presentation;

import com.g3c1.temi.domain.purchase.presentation.dto.request.PurchasedFoodRequest;
import com.g3c1.temi.domain.purchase.presentation.dto.response.PurchasedFoodListResponse;
import com.g3c1.temi.domain.purchase.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;
    @PostMapping
    public ResponseEntity<Void> addPurchasedFood(@RequestBody PurchasedFoodRequest purchaseFoodRequest){
        purchaseService.addPurchasedFood(purchaseFoodRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<PurchasedFoodListResponse>> getPurchaseFoodList(){
        return new ResponseEntity<>(purchaseService.getPurchaseFoodInfo(),HttpStatus.OK);
    }
}
