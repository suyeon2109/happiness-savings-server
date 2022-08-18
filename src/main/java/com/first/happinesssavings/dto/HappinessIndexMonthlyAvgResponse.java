package com.first.happinesssavings.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class HappinessIndexMonthlyAvgResponse {
    private int monthNum;
    private double monthlyAvg;
}
