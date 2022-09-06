package com.first.happinesssavings;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.first.happinesssavings.domain.IdProviderType;
import com.first.happinesssavings.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void signUp() throws Exception {
        mockMvc.perform(post("/members/signUp"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNumber());
    }

    @Test
    void login() throws Exception {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        ReflectionTestUtils.setField(loginRequestDto, "idProviderType", IdProviderType.UUID);
        ReflectionTestUtils.setField(loginRequestDto, "idProviderUserId", "idProviderUserId");

        mockMvc.perform(post("/members/login")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsBytes(loginRequestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNumber());
    }
}