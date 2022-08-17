package com.first.happinesssavings.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class HappinessIndexAvgRequest {
    private String memberUuid;
    private LocalDateTime date;

    public HappinessIndexAvgRequest(String memberUuid, LocalDateTime date) {
        this.memberUuid = memberUuid;
        this.date = date;
    }
}
