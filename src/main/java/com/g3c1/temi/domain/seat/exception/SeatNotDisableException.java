package com.g3c1.temi.domain.seat.exception;

import com.g3c1.temi.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SeatNotDisableException extends RuntimeException {
    private final ErrorCode errorCode;

    public SeatNotDisableException(String message){
        super(message);
        this.errorCode = ErrorCode.SEAT_NOT_DISABLE;
    }
}
