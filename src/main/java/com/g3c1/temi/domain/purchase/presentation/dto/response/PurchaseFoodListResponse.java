package com.g3c1.temi.domain.purchase.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class PurchaseFoodListResponse {
    private final Long id;
    private final Long seatNumber;
    private final List<FoodInfo> foodInfoList;

    @Getter @Builder
    @AllArgsConstructor
    public static class FoodInfo{
        private final String foodName;
        private final Long foodCount;
    }
}
