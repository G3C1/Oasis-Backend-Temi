package com.g3c1.temi.domain.food.service;

import com.g3c1.temi.domain.food.presentation.dto.response.CategoryFoodResponse;

import java.util.List;

public interface FoodService {
    List<CategoryFoodResponse> getCategoryFoodList();
}
