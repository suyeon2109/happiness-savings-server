package com.first.happinesssavings.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    /**
     * 사용자 아이디
     */
    private String idProviderUserId;
    /**
     * 인증제공자
     */
    @Enumerated(EnumType.STRING)
    private IdProviderType idProviderType;

    public static Member of(IdProviderType idProviderType, String idProviderUserId) {
        Member member = new Member();
        member.idProviderType = idProviderType;
        member.idProviderUserId = idProviderUserId;
        return member;
    }
}
