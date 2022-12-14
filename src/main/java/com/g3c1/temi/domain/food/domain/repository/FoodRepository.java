package com.g3c1.temi.domain.food.domain.repository;

import com.g3c1.temi.domain.category.domain.entity.Category;
import com.g3c1.temi.domain.food.domain.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food,Long> {
    List<Food> findFoodByCategory(Category category);
    Optional<Food> findFoodById(Long id);
}
