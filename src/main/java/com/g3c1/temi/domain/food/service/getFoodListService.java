package com.g3c1.temi.domain.food.service;

import com.g3c1.temi.domain.food.entity.Food;
import com.g3c1.temi.domain.food.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class getFoodListService {
    private final FoodRepository foodRepository;

    public List<Food> execute(){
       return foodRepository.findAll();
    }
}
