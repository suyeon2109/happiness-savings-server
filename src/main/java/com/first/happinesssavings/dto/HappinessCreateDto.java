package com.first.happinesssavings.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class HappinessCreateDto {
    private String title;
    private String content;
    private int happinessIndex;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String memberUuid;
    /**
     * 이미지
     */
    private MultipartFile file;
}
