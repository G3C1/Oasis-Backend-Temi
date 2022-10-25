package com.g3c1.temi.domain.seat.domain.repository;

import com.g3c1.temi.domain.seat.domain.entity.Seat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends CrudRepository<Seat,Long> {
    List<Seat> findAll();
    Optional<Seat> findSeatById(Long SeatId);
}
