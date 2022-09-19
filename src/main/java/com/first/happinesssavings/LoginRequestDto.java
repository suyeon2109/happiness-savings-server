package com.first.happinesssavings;

import com.first.happinesssavings.domain.IdProviderType;
import lombok.Getter;

@Getter
public class LoginRequestDto {
    private IdProviderType idProviderType;
    private String idProviderUserId;
}
