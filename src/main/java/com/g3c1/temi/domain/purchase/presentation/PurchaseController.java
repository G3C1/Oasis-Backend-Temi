package com.g3c1.temi.domain.purchase.presentation;

import com.g3c1.temi.domain.purchase.entity.Purchase;
import com.g3c1.temi.domain.purchase.presentation.dto.request.PurchaseFoodRequest;
import com.g3c1.temi.domain.purchase.service.impl.GetPurchaseFoodListServiceImpl;
import com.g3c1.temi.domain.purchase.service.impl.PurchaseFoodServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("purchase")
public class PurchaseController {
    private final PurchaseFoodServiceImpl purchaseFoodService;
    private final GetPurchaseFoodListServiceImpl getPurchaseFoodListService;
    @PostMapping
    public ResponseEntity<Void> purchaseFood(@RequestBody PurchaseFoodRequest purchaseFoodRequest){
        purchaseFoodService.execute(purchaseFoodRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Purchase>> getPurchaseFoodList(){
        return new ResponseEntity<>(getPurchaseFoodListService.execute(),HttpStatus.OK);
    }
}
