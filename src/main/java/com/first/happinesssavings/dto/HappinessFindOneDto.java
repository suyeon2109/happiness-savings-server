package com.first.happinesssavings.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HappinessFindOneDto {
    private String memberUuid;
    private Long happinessId;

    public HappinessFindOneDto(String memberUuid, Long happinessId) {
        this.memberUuid = memberUuid;
        this.happinessId = happinessId;
    }
}
