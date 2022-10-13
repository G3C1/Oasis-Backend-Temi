package com.g3c1.temi.domain.seat.service;

import com.g3c1.temi.domain.seat.entity.Seat;
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
        List<Seat> seatList = getSeatList();
        return getSeatInfoList(seatList);
    }
    private List<Seat> getSeatList(){
        return seatRepository.findAll();
    }
    private List<SeatInfoResponse> getSeatInfoList(List<Seat> seatList) {
        List<SeatInfoResponse> seatInfoList = seatList.stream().map(seat -> SeatInfoResponse.builder()
                .seatId(seat.getId())
                .seatNumber(seat.getSeatNumber())
                .seated(seat.getSeated())
                .severalPeople(seat.getSeveralPeople())
                .build()).collect(Collectors.toList());
        return seatInfoList;
    }
}
