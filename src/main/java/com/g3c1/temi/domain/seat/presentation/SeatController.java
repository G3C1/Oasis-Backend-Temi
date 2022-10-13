package com.g3c1.temi.domain.seat.presentation;

import com.g3c1.temi.domain.seat.presentation.dto.response.SeatInfoResponse;
import com.g3c1.temi.domain.seat.service.GetSeatInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("seat")
public class SeatController {
    private final GetSeatInfoService getSeatInfoService;

    @GetMapping
    public ResponseEntity<List<SeatInfoResponse>> getSeatInfo(){
        List<SeatInfoResponse> seatInfoList = getSeatInfoService.getSeatInfo();
        return new ResponseEntity<>(seatInfoList, HttpStatus.OK);
    }
}
