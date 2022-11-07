package com.g3c1.temi.domain.seat.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter @Builder
@RequiredArgsConstructor
public class SeatInfoResponse {
    private final Long seatId;
    private final Long seatNumber;
    private final Long severalPeople;
    private final Boolean enabled;
}
