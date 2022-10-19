package com.g3c1.temi.domain.food.service;

import com.g3c1.temi.domain.food.entity.Category;
import com.g3c1.temi.domain.food.presentation.dto.response.FoodInfoResponse;
import com.g3c1.temi.domain.food.presentation.dto.response.CategoryFoodListResponse;
import com.g3c1.temi.domain.food.repository.CategoryRepository;
import com.g3c1.temi.domain.food.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetFoodListService {
    private final FoodRepository foodRepository;
    private final CategoryRepository categoryRepository;

    public List<CategoryFoodListResponse> execute(){
        List<Category> categories = getCategoryList();
        return getCategoryFoodList(categories);
    }
    private List<Category> getCategoryList(){
        return categoryRepository.findAll();
    }
    private List<FoodInfoResponse> getFoodInfoListByCategory(String category){
       return foodRepository.findAllByCategory(category).stream().map(food -> FoodInfoResponse.builder()
                .id(food.getId())
                .name(food.getName())
                .img(food.getImg())
                .price(food.getPrice())
                .servings(food.getServings())
                .description(food.getDescription())
                .build()).collect(Collectors.toList());
    }
    private List<CategoryFoodListResponse> getCategoryFoodList(List<Category> categories){
        return categories.stream().map(category -> {
            List<FoodInfoResponse> foodInfoResponses = getFoodInfoListByCategory(category.getName());
            return CategoryFoodListResponse.builder()
                    .id(category.getId())
                    .category(category.getName())
                    .foodList(foodInfoResponses)
                    .build();
        }).collect(Collectors.toList());
    }
}
