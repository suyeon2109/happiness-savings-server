package com.first.happinesssavings.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class HappinessDto {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private int happinessIndex;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String memberUuid;
}
