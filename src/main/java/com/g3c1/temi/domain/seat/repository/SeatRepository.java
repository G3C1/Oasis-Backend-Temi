package com.g3c1.temi.domain.seat.repository;

import com.g3c1.temi.domain.seat.entity.Seat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeatRepository extends CrudRepository<Seat,Long> {
    List<Seat> findAll();
    Seat findSeatBySeatNumber(int seatNumber);
}
