package com.g3c1.temi.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNKNOWN("알수없는 에러",500);
    private final String message;
    private final int status;
}
