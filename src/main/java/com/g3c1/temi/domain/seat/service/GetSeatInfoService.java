package com.g3c1.temi.domain.seat.service;

import com.g3c1.temi.domain.seat.presentation.dto.response.SeatInfoResponse;
import com.g3c1.temi.domain.seat.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetSeatInfoService {
    private final SeatRepository seatRepository;

    @Transactional(readOnly = true)
    public List<SeatInfoResponse> getSeatInfo(){
        return getSeatInfoResponse();
    }
    private List<SeatInfoResponse> getSeatInfoResponse() {
        List<SeatInfoResponse> seatInfoList = seatRepository.findAll().stream().map(seat -> SeatInfoResponse.builder()
                .seatId(seat.getId())
                .seatNumber(seat.getSeatNumber())
                .seated(seat.getSeated())
                .severalPeople(seat.getSeveralPeople())
                .build()).collect(Collectors.toList());
        return seatInfoList;
    }
}
