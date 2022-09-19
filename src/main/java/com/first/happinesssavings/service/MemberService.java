package com.first.happinesssavings.service;

import com.first.happinesssavings.domain.IdProviderType;
import com.first.happinesssavings.domain.Member;
import com.first.happinesssavings.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    /**
     * UUID 로 회원가입
     * @return 새로 생성된 member
     */
    @Transactional
    public Member signUp() {
        IdProviderType idProviderType = IdProviderType.UUID;
        String idProviderUserId;
        do {
            idProviderUserId = UUID.randomUUID().toString();
        } while (isDuplicated(idProviderType, idProviderUserId));

        return createMember(idProviderType, idProviderUserId);
    }

    /**
     * 이미 사용중인 아이디인지 검사
     */
    private boolean isDuplicated(IdProviderType idProviderType, String idProviderUserId) {
        return memberRepository.findByIdProviderTypeAndIdProviderUserId(idProviderType, idProviderUserId).isPresent();
    }

    /**
     * member 생성
     * @param idProviderType 인증제공자
     * @param idProviderUserId 인증제공자 userId
     * @return 새로 생성된 member
     */
    private Member createMember(IdProviderType idProviderType, String idProviderUserId) {
        Member member = Member.of(idProviderType, idProviderUserId);
        return memberRepository.save(member);
    }

    /**
     * 조건에 맞는 member 가 있으면 리턴, 없으면 새로 생성
     * @param idProviderType 인증제공자
     * @param idProviderUserId 인증제공자 userId
     * @return member
     */
    @Transactional
    public Member getOrCreate(IdProviderType idProviderType, String idProviderUserId) {
        return memberRepository.findByIdProviderTypeAndIdProviderUserId(idProviderType, idProviderUserId)
                .orElseGet(() -> createMember(idProviderType, idProviderUserId));
    }
}
