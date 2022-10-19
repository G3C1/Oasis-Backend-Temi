package com.g3c1.temi.domain.food.presentation;

import com.g3c1.temi.domain.food.presentation.dto.response.FoodListResponse;
import com.g3c1.temi.domain.food.service.GetFoodListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("food")
public class FoodController {
    private final GetFoodListService getFoodListService;

    @GetMapping
    public ResponseEntity<List<FoodListResponse>> getFoodList(){
        List<FoodListResponse> foodList = getFoodListService.execute();
        return new ResponseEntity<>(foodList, HttpStatus.OK);
    }
}
