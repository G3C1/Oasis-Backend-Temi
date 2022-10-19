package com.g3c1.temi.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    SEAT_NOT_DISABLE("사용 중이지않는 좌석입니다.",400),
    FOOD_NOT_FOUND("음식을 찾을 수 없습니다.",404),
    SEAT_NOT_FOUND("좌석을 찾을 수 없습니다.",404),
    SEAT_NOT_ENABLE("좌석을 사용할 수 없습니다.",409),
    UNKNOWN("알수없는 에러",500);
    private final String message;
    private final int status;
}
