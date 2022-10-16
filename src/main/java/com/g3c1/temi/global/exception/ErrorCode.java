package com.g3c1.temi.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    SEAT_NOT_FOUND("좌석을 찾을 수 없습니다.",404),
    UNKNOWN("알수없는 에러",500);
    private final String message;
    private final int status;
}
