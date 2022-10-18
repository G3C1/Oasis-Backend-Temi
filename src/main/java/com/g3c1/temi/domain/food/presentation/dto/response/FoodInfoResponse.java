package com.g3c1.temi.domain.food.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter @Builder
@RequiredArgsConstructor
public class FoodInfoResponse {
    private final Long id;
    private final String name;
    private final String img;
    private final String description;
    private final Integer servings;
    private final Long price;
}
