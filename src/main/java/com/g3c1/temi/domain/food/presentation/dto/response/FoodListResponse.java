package com.g3c1.temi.domain.food.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter @Builder
@RequiredArgsConstructor
public class FoodListResponse {
    private final Long id;
    private final String category;
    private final List<FoodInfoResponse> foodList;
}
