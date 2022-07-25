package com.first.happinesssavings.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HappinessFindByTitleDto {
    private String memberUuid;
    private String title;

    public HappinessFindByTitleDto(String memberUuid, String title) {
        this.memberUuid = memberUuid;
        this.title = title;
    }
}
