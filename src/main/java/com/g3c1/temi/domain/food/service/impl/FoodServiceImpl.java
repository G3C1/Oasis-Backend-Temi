package com.g3c1.temi.domain.food.service.impl;

import com.g3c1.temi.domain.category.domain.entity.Category;
import com.g3c1.temi.domain.category.domain.repository.CategoryRepository;
import com.g3c1.temi.domain.food.presentation.dto.response.CategoryFoodResponse;
import com.g3c1.temi.domain.food.domain.repository.FoodRepository;
import com.g3c1.temi.domain.food.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true,rollbackFor = Exception.class)
    @Override
    public List<CategoryFoodResponse> getCategoryFoodList() {
        List<Category> categories = getCategoryList();
        return getCategoryFoodList(categories);
    }
    private List<Category> getCategoryList(){
        return categoryRepository.findAll();
    }
    private List<CategoryFoodResponse> getCategoryFoodList(List<Category> categories){
        return categories.stream().map(category -> {
            List<CategoryFoodResponse.FoodInfo> foodInfoResponses = getFoodInfoListByCategory(category);
            return CategoryFoodResponse.builder()
                    .id(category.getId())
                    .category(category.getName())
                    .foodList(foodInfoResponses)
                    .build();
        }).collect(Collectors.toList());
    }
    private List<CategoryFoodResponse.FoodInfo> getFoodInfoListByCategory(Category category){
        return foodRepository.findFoodByCategory(category).stream().map(food -> CategoryFoodResponse.FoodInfo.builder()
                .id(food.getId())
                .name(food.getName())
                .img(food.getImg())
                .price(food.getPrice())
                .servings(food.getServings())
                .description(food.getDescription())
                .build()).collect(Collectors.toList());
    }
}
