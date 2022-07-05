package com.first.happinesssavings.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HappinessFindByTitleDto {
    private String memberUuid;
    private String title;

    public HappinessFindByTitleDto(String memberUuid, String title) {
        this.memberUuid = memberUuid;
        this.title = title;
    }
}
