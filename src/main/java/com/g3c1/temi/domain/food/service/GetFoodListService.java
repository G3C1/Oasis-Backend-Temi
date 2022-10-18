package com.g3c1.temi.domain.food.service;

import com.g3c1.temi.domain.food.entity.Category;
import com.g3c1.temi.domain.food.entity.Food;
import com.g3c1.temi.domain.food.presentation.dto.response.FoodInfoResponse;
import com.g3c1.temi.domain.food.presentation.dto.response.FoodListResponse;
import com.g3c1.temi.domain.food.repository.CategoryRepository;
import com.g3c1.temi.domain.food.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetFoodListService {
    private final FoodRepository foodRepository;
    private final CategoryRepository categoryRepository;

    public List<FoodListResponse> execute(){
        List<Category> categories = getCategoryList();
        return getCategoryFoodList(categories);

    }
    private List<Category> getCategoryList(){
        return categoryRepository.findAll();
    }
    private List<FoodListResponse> getCategoryFoodList(List<Category> categories){
        List<FoodListResponse> foodListResponses = categories.stream().map(category -> {
            List<FoodInfoResponse> foodInfoResponses = getFoodListByCategory(category.getName());
            return FoodListResponse.builder()
                    .id(category.getId())
                    .category(category.getName())
                    .foodList(foodInfoResponses)
                    .build();
        }).collect(Collectors.toList());
        return foodListResponses;
    }
    private List<FoodInfoResponse> getFoodListByCategory(String category){
       return foodRepository.findAllByCategory(category).stream().map(food -> FoodInfoResponse.builder()
                .id(food.getId())
                .name(food.getName())
                .img(food.getImg())
                .price(food.getPrice())
                .servings(food.getServings())
                .description(food.getDescription())
                .build()).collect(Collectors.toList());
    }
}
