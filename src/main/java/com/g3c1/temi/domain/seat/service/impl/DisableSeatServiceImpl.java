package com.g3c1.temi.domain.seat.service.impl;

import com.g3c1.temi.domain.seat.entity.Seat;
import com.g3c1.temi.domain.seat.utils.SeatUtils;
import com.g3c1.temi.domain.seat.utils.SeatValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DisableSeatServiceImpl{
    private final SeatUtils seatUtils;
    private final SeatValidator seatValidator;

    @Transactional(rollbackFor = Exception.class)
    public void execute(Long seatId){
        Seat seatInfo = seatUtils.getSeatInfo(seatId);
        seatValidator.checkSeatIsNotUsed(seatInfo);
        updateSeated(seatInfo);
    }
    private void updateSeated(Seat seatInfo){
            seatInfo.updateSeated(true);
    }
}

