package com.g3c1.temi.domain.seat.service.impl;

import com.g3c1.temi.domain.seat.domain.entity.Seat;
import com.g3c1.temi.domain.seat.service.EnableSeatService;
import com.g3c1.temi.domain.seat.utils.SeatUtils;
import com.g3c1.temi.domain.seat.utils.SeatValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EnableSeatServiceImpl implements EnableSeatService {
    private final SeatUtils seatUtils;
    private final SeatValidator seatValidator;

    @Transactional(rollbackFor = Exception.class)
    public void execute(Long seatId){
        Seat seatInfo = seatUtils.getSeatInfo(seatId);
        seatValidator.checkSeatIsUsed(seatInfo);
        updateSeated(seatInfo);
    }
    private void updateSeated(Seat seatInfo){
        seatInfo.updateSeated(false);
    }
}
