package com.g3c1.temi.domain.purchase.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class PurchasedFoodRequest {
    
    private final Long seatId;
    private final List<PurchaseFoodList> foodLists;

    @Getter @Builder
    @AllArgsConstructor
    public static class PurchaseFoodList{
        private final Long foodId;
        private final Long foodCount;
    }
}
