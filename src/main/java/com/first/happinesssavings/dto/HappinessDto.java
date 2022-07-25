package com.first.happinesssavings.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
public class HappinessDto {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String memberUuid;
}
