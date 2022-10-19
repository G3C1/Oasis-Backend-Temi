package com.g3c1.temi.domain.purchase.exception;

import com.g3c1.temi.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FoodNotFoundException extends RuntimeException{
    private final ErrorCode errorCode;

    public FoodNotFoundException(String message){
        super(message);
        this.errorCode = ErrorCode.FOOD_NOT_FOUND;
    }
}
