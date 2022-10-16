package com.g3c1.temi.domain.seat.service;

import com.g3c1.temi.domain.seat.entity.Seat;
import com.g3c1.temi.domain.seat.exception.SeatNotFoundException;
import com.g3c1.temi.domain.seat.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SelectSeatService {
    private final SeatRepository seatRepository;

    @Transactional(rollbackFor = Exception.class)
    public void patchSeatInfo(Long seatId){
        Seat seatInfo = findSeatInfoThroughSeatNumber(seatId);
        updateSeated(seatInfo);

    }
    private Seat findSeatInfoThroughSeatNumber(Long seatNumber){
        return seatRepository.findSeatById(seatNumber).orElseThrow(()->new SeatNotFoundException("좌석을 찾을 수 없습니다."));
    }
    private void updateSeated(Seat seatInfo){
        seatInfo.updateSeated();
    }
}
