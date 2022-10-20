package com.g3c1.temi.domain.seat.service.impl;

import com.g3c1.temi.domain.seat.entity.Seat;
import com.g3c1.temi.domain.seat.presentation.dto.response.SeatInfoResponse;
import com.g3c1.temi.domain.seat.service.FindSeatInfoService;
import com.g3c1.temi.domain.seat.utils.SeatUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class FindSeatInfoServiceImpl implements FindSeatInfoService {
    private final SeatUtils seatUtils;
    @Transactional(readOnly = true,rollbackFor = Exception.class)
    public List<SeatInfoResponse> execute(){
        List<Seat> seatList = seatUtils.getSeatList();
        return getSeatInfoList(seatList);
    }
    private List<SeatInfoResponse> getSeatInfoList(List<Seat> seatList) {
        return seatList.stream().map(seat -> SeatInfoResponse.builder()
                .seatId(seat.getId())
                .seatNumber(seat.getSeatNumber())
                .seated(seat.getEnabled())
                .severalPeople(seat.getSeveralPeople())
                .build()).collect(Collectors.toList());
    }
}
