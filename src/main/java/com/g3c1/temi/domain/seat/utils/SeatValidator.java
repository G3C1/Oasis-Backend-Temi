package com.g3c1.temi.domain.seat.utils;

import com.g3c1.temi.domain.seat.entity.Seat;
import com.g3c1.temi.domain.seat.exception.SeatNotEnableException;
import com.g3c1.temi.domain.seat.exception.SeatNotAbleException;

public class SeatValidator {
    public void checkSeatIsNotUsed(Seat seatInfo){
        if(seatInfo.getEnabled()) throw new SeatNotAbleException("사용중이지 않은 좌석입니다.");
    }
    public void checkSeatIsUsed(Seat seatInfo){
        if(!seatInfo.getEnabled()) throw new SeatNotEnableException("좌석을 사용할 수 없습니다.");
    }
}
