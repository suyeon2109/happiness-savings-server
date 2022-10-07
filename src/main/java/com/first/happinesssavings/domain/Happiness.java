package com.first.happinesssavings.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@ToString
public class Happiness {

    @Id @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private int happinessIndex;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String memberUuid;
}
