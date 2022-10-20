package com.g3c1.temi.domain.food.service;

import com.g3c1.temi.domain.food.presentation.dto.response.CategoryFoodListResponse;

import java.util.List;

public interface GetFoodListService {
    List<CategoryFoodListResponse> execute();
}
