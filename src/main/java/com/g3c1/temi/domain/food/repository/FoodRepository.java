package com.g3c1.temi.domain.food.repository;

import com.g3c1.temi.domain.food.entity.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food,Long> {
}
