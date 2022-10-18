package com.g3c1.temi.domain.food.repository;

import com.g3c1.temi.domain.food.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Long> {
    List<Food> findAllByCategory(String category);
}
