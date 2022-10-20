package com.g3c1.temi.domain.seat.service;

import com.g3c1.temi.domain.seat.presentation.dto.response.SeatInfoResponse;

import java.util.List;

public interface FindSeatInfoService {
    List<SeatInfoResponse> execute();
}
