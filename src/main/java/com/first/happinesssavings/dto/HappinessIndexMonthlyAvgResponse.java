package com.first.happinesssavings.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class HappinessIndexMonthlyAvgResponse {
    private LocalDateTime month;
    private double monthlyAvg;
}
