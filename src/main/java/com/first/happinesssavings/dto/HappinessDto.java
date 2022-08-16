package com.first.happinesssavings.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    private String memberUuid;
}
