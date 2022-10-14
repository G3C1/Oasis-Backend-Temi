package com.g3c1.temi.domain.seat.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SeatNumberRequest {
    private final int seatNumber;
}
