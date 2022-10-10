package com.g3c1.temi.domain.order.entity;

import com.g3c1.temi.domain.seat.entity.Seat;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @Column(name = "food_id")
    private Food food;
    @ManyToOne
    @Column(name = "seat_id")
    private Seat seat;
}
