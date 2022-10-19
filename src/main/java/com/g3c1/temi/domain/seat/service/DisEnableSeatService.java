package com.g3c1.temi.domain.seat.service;

import com.g3c1.temi.domain.seat.entity.Seat;
import com.g3c1.temi.domain.seat.utils.SeatUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DisEnableSeatService {

    private final SeatUtils seatUtils;

        @Transactional(rollbackFor = Exception.class)
        public void execute(Long seatId){
            Seat seatInfo = seatUtils.getSeatInfo(seatId);
            updateSeated(seatInfo);
        }
        private void updateSeated(Seat seatInfo){
            seatInfo.updateSeated(true);
        }
    }

