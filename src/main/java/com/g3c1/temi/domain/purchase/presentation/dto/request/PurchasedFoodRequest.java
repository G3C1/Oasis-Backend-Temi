package com.g3c1.temi.domain.purchase.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class PurchasedFoodRequest {
    @NotNull(message = "좌석아이디를 입력해주세요")
    private final Long seatId;
    @NotNull(message = "주문할 음식이 존재하지 않습니다.")
    private final List<PurchaseFoodList> foodList;

    @Getter @Builder @Valid
    @AllArgsConstructor
    public static class PurchaseFoodList{
        @NotNull(message = "음식아이디가 존재하지 않습니다.")
        private final Long foodId;
        @NotNull(message = "음식 수량이 존재하지 않습니다.")
        private final Long foodCount;
    }
}
