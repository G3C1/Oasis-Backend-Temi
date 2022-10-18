package com.g3c1.temi.domain.purchase.entity;

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

    public Purchase(Food foodInfo, Seat seatInfo) {
        this.food = foodInfo;
        this.seat = seatInfo;
    }
}
