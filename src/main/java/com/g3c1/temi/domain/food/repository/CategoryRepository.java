package com.g3c1.temi.domain.food.repository;


import com.g3c1.temi.domain.food.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findAll();
}
