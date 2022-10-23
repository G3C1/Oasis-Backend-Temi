package com.g3c1.temi.domain.food.service.impl;

import com.g3c1.temi.domain.category.entity.Category;
import com.g3c1.temi.domain.food.presentation.dto.response.FoodInfoResponse;
import com.g3c1.temi.domain.food.presentation.dto.response.CategoryFoodListResponse;
import com.g3c1.temi.domain.category.repository.CategoryRepository;
import com.g3c1.temi.domain.food.repository.FoodRepository;
import com.g3c1.temi.domain.food.service.GetFoodListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetFoodListServiceImpl implements GetFoodListService {
    private final FoodRepository foodRepository;
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true,rollbackFor = Exception.class)
    public List<CategoryFoodListResponse> execute(){
        List<Category> categories = getCategoryList();
        return getCategoryFoodList(categories);
    }
    private List<Category> getCategoryList(){
        return categoryRepository.findAll();
    }
    private List<CategoryFoodListResponse> getCategoryFoodList(List<Category> categories){
        return categories.stream().map(category -> {
            List<FoodInfoResponse> foodInfoResponses = getFoodInfoListByCategory(category);
            return CategoryFoodListResponse.builder()
                    .id(category.getId())
                    .category(category.getName())
                    .foodList(foodInfoResponses)
                    .build();
        }).collect(Collectors.toList());
    }
    private List<FoodInfoResponse> getFoodInfoListByCategory(Category category){
       return foodRepository.findFoodByCategory(category).stream().map(food -> FoodInfoResponse.builder()
                .id(food.getId())
                .name(food.getName())
                .img(food.getImg())
                .price(food.getPrice())
                .servings(food.getServings())
                .description(food.getDescription())
                .build()).collect(Collectors.toList());
    }
}
