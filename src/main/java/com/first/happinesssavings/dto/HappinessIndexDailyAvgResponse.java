package com.first.happinesssavings.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class HappinessIndexDailyAvgResponse {

    private LocalDateTime lastTenDays;
    private double dailyAvg;
}
