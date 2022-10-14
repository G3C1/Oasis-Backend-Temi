package com.g3c1.temi.domain.seat.presentation;

import com.g3c1.temi.domain.seat.presentation.dto.request.SeatNumberRequest;
import com.g3c1.temi.domain.seat.presentation.dto.response.SeatInfoResponse;
import com.g3c1.temi.domain.seat.service.FindSeatInfoService;
import com.g3c1.temi.domain.seat.service.SelectSeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("seat")
public class SeatController {
    private final FindSeatInfoService getSeatInfoService;
    private final SelectSeatService patchSeatService;

    @GetMapping
    public ResponseEntity<List<SeatInfoResponse>> getSeatInfo(){
        List<SeatInfoResponse> seatInfoList = getSeatInfoService.getSeatInfo();
        return new ResponseEntity<>(seatInfoList, HttpStatus.OK);
    }
    @PatchMapping
    public ResponseEntity<Void> patchSeatInfo(@RequestParam(value = "seatNumber") SeatNumberRequest seatNumberRequest){
        patchSeatService.patchSeatInfo(seatNumberRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
