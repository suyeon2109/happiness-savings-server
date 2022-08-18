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
    private LocalDateTime nowDate;

    public HappinessIndexAvgRequest(String memberUuid, LocalDateTime nowDate) {
        this.memberUuid = memberUuid;
        this.nowDate = nowDate;
    }
}
