package com.g3c1.temi.domain.order.entity;

import com.g3c1.temi.domain.food.entity.Food;
import com.g3c1.temi.domain.seat.entity.Seat;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    private Food food;
    @ManyToOne()
    private Seat seat;
}
