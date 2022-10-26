package com.g3c1.temi.domain.seat.presentation;

import com.g3c1.temi.domain.seat.presentation.dto.response.SeatInfoResponse;
import com.g3c1.temi.domain.seat.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("seat")
public class SeatController {
    private final SeatService seatService;

    @GetMapping
    public ResponseEntity<List<SeatInfoResponse>> getSeatInfo(){
        List<SeatInfoResponse> seatInfoList = seatService.findSeatInfo();
        return new ResponseEntity<>(seatInfoList, HttpStatus.OK);
    }
    @PatchMapping("/{seatId}")
    public ResponseEntity<Void> enableSeat(@PathVariable("seatId")Long seatId){
        seatService.enableSeat(seatId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/cancel/{seatId}")
    public ResponseEntity<Void> disableSeat(@PathVariable("seatId")Long seatId){
        seatService.disableSeat(seatId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
