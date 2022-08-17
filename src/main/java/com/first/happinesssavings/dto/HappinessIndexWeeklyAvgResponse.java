package com.first.happinesssavings.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HappinessIndexWeeklyAvgResponse {
    private int week;
    private double weeklyAvg;
}
