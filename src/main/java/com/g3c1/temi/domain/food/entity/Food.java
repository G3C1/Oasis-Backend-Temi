package com.g3c1.temi.domain.food.entity;

import com.g3c1.temi.domain.category.entity.Category;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String img;
    private String description;
    private int servings;
    private Long price;
    @ManyToOne()
    private Category category;
}
