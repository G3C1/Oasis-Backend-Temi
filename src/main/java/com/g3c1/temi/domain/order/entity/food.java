package com.g3c1.temi.domain.order.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class food {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2",strategy = "uuid2")
    private UUID id;
    private String name;
    private String img;
    private String description;
    private Integer servings;
    private Integer price;
}
