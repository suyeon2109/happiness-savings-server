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
    private LocalDateTime now;

    public HappinessIndexAvgRequest(String memberUuid, LocalDateTime now) {
        this.memberUuid = memberUuid;
        this.now = now;
    }
}
