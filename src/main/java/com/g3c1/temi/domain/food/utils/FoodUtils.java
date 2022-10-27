package com.g3c1.temi.domain.food.utils;

import com.g3c1.temi.domain.food.domain.entity.Food;
import com.g3c1.temi.domain.food.domain.repository.FoodRepository;
import com.g3c1.temi.domain.purchase.exception.FoodNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodUtils {
    private final FoodRepository foodRepository;

    public Food findFoodInfoById(Long foodId){
        return foodRepository.findFoodById(foodId).orElseThrow(() -> new FoodNotFoundException("음식을 찾을 수 없습니다."));
    }
}
