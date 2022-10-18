package com.g3c1.temi.domain.purchase.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class PurchaseFoodRequest {
    private final Long seatId;
    private final List<Long> foodIdList;
}
