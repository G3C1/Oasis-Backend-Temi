package com.g3c1.temi.domain.purchase.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter @Builder
@RequiredArgsConstructor
public class PurchaseFoodListResponse {
    private final int seatNumber;
    private final List<FoodInfo> foodInfoList;

    @Getter @Builder
    @AllArgsConstructor
    public static class FoodInfo{
        private final String foodName;
        private final Long foodCount;
    }
}
