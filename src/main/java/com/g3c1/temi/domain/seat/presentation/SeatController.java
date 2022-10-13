package com.g3c1.temi.domain.seat.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("seat")
public class SeatController {
    @GetMapping
    public ResponseEntity<Void> getSeatInfo(){
        return null;
    }
}
