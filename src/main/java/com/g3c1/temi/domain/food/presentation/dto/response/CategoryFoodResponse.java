package com.g3c1.temi.domain.food.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter @Builder
@RequiredArgsConstructor
public class CategoryFoodResponse {
    private final Long id;
    private final String category;
    private final List<FoodInfo> foodList;

    @Getter @Builder
    @AllArgsConstructor
    public static class FoodInfo{
        private final Long id;
        private final String name;
        private final String img;
        private final String description;
        private final Long servings;
        private final Long price;
    }
}
