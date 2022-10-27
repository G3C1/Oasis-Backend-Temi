package com.g3c1.temi.domain.purchase.domain.entity;

import com.g3c1.temi.domain.food.domain.entity.Food;
import com.g3c1.temi.domain.seat.entity.Seat;
import com.g3c1.temi.global.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Purchase extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    private Food food;
    @ManyToOne()
    private Seat seat;
    private Long foodCount;

    public Purchase(Seat seatInfo, Food foodInfoById, Long foodCount) {
        this.seat = seatInfo;
        this.food = foodInfoById;
        this.foodCount = foodCount;
    }
}
