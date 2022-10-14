package com.g3c1.temi.domain.seat.service;

import com.g3c1.temi.domain.seat.entity.Seat;
import com.g3c1.temi.domain.seat.presentation.dto.request.SeatNumberRequest;
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
    public void patchSeatInfo(SeatNumberRequest seatNumberRequest){
        Seat seatInfo = findSeatInfoThroughSeatNumber(seatNumberRequest.getSeatNumber());
        updateSeated(seatInfo);

    }
    private Seat findSeatInfoThroughSeatNumber(int seatNumber){
        return seatRepository.findSeatBySeatNumber(seatNumber);
    }
    private void updateSeated(Seat seatInfo){
        seatInfo.updateSeated();
    }
}
