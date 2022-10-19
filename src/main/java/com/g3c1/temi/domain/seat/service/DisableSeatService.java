package com.g3c1.temi.domain.seat.service;

import com.g3c1.temi.domain.seat.entity.Seat;
import com.g3c1.temi.domain.seat.exception.SeatNotEnableException;
import com.g3c1.temi.domain.seat.utils.SeatUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DisableSeatService {

    private final SeatUtils seatUtils;

        @Transactional(rollbackFor = Exception.class)
        public void execute(Long seatId){
            Seat seatInfo = seatUtils.getSeatInfo(seatId);
            checkEnabled(seatInfo);
            updateSeated(seatInfo);
        }
    public void checkEnabled(Seat seat){
        if(seat.getEnabled() == true) throw new SeatNotEnableException("좌석을 사용할 수 없습니다.");
    }
        private void updateSeated(Seat seatInfo){
            seatInfo.updateSeated(true);
        }
    }

