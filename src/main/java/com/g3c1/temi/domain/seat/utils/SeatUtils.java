package com.g3c1.temi.domain.seat.utils;

import com.g3c1.temi.domain.seat.entity.Seat;
import com.g3c1.temi.domain.seat.exception.SeatNotFoundException;
import com.g3c1.temi.domain.seat.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatUtils {
    private final SeatRepository seatRepository;

    public Seat getSeatInfo(Long seatId){
        return seatRepository.findSeatById(seatId).orElseThrow(()-> new SeatNotFoundException("좌석을 찾을 수 없습니다."));
    }
    public List<Seat> getSeatList(){
        return seatRepository.findAll();
    }
}
