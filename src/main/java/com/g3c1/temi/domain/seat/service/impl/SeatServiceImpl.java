package com.g3c1.temi.domain.seat.service.impl;

import com.g3c1.temi.domain.seat.entity.Seat;
import com.g3c1.temi.domain.seat.presentation.dto.response.SeatInfoResponse;
import com.g3c1.temi.domain.seat.service.SeatService;
import com.g3c1.temi.domain.seat.utils.SeatUtils;
import com.g3c1.temi.domain.seat.utils.SeatValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {
    private final SeatUtils seatUtils;
    private final SeatValidator seatValidator;

    @Transactional(readOnly = true,rollbackFor = Exception.class)
    @Override
    public List<SeatInfoResponse> findSeatInfo() {
        List<Seat> seatList = seatUtils.getSeatList();
        return getSeatInfoList(seatList);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void enableSeat(Long seatId) {
        Seat seatInfo = seatUtils.getSeatInfo(seatId);
        seatValidator.checkSeatIsUsed(seatInfo);
        updateSeated(seatInfo,false);
    }

    @Override
    public void disableSeat(Long seatId) {
        Seat seatInfo = seatUtils.getSeatInfo(seatId);
        seatValidator.checkSeatIsNotUsed(seatInfo);
        updateSeated(seatInfo,true);
    }

    private List<SeatInfoResponse> getSeatInfoList(List<Seat> seatList) {
        return seatList.stream().map(seat -> SeatInfoResponse.builder()
                .seatId(seat.getId())
                .seatNumber(seat.getSeatNumber())
                .enabled(seat.getEnabled())
                .severalPeople(seat.getSeveralPeople())
                .build()).collect(Collectors.toList());
    }
    private void updateSeated(Seat seatInfo,Boolean enabled){
        seatInfo.updateSeated(enabled);
    }
}
