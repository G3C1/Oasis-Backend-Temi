package com.g3c1.temi.domain.seat.presentation;

import com.g3c1.temi.domain.seat.presentation.dto.response.SeatInfoResponse;
import com.g3c1.temi.domain.seat.service.DisableSeatService;
import com.g3c1.temi.domain.seat.service.EnableSeatService;
import com.g3c1.temi.domain.seat.service.FindSeatInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("seat")
public class SeatController {
    private final FindSeatInfoService findSeatInfoService;
    private final EnableSeatService enableSeatService;
    private final DisableSeatService disEnableSeatService;


    @GetMapping
    public ResponseEntity<List<SeatInfoResponse>> getSeatInfo(){
        List<SeatInfoResponse> seatInfoList = findSeatInfoService.execute();
        return new ResponseEntity<>(seatInfoList, HttpStatus.OK);
    }
    @PatchMapping("/{seatId}")
    public ResponseEntity<Void> enableSeat(@PathVariable("seatId")Long seatId){
        enableSeatService.execute(seatId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/cancel/{seatId}")
    public ResponseEntity<Void> disEnableSeat(@PathVariable("seatId")Long seatId){
        disEnableSeatService.execute(seatId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
