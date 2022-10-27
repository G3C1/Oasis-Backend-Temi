package com.g3c1.temi.domain.category.domain.repository;


import com.g3c1.temi.domain.category.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findAll();
}
