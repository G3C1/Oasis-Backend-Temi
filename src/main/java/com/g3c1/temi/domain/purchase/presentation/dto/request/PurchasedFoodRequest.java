package com.g3c1.temi.domain.purchase.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class PurchasedFoodRequest {
    @NotBlank(message = "좌석아이디를 입력해주세요")
    private final Long seatId;
    private final List<PurchaseFoodList> foodLists;

    @Getter @Builder
    @AllArgsConstructor
    public static class PurchaseFoodList{
        @NotBlank(message = "음식을 선택해주세요")
        private final Long foodId;
        @NotBlank(message = "수량을 입력해주세요")
        private final Long foodCount;
    }
}
