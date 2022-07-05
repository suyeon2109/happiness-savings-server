package com.first.happinesssavings.service;

import com.first.happinesssavings.domain.Member;
import com.first.happinesssavings.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Transactional
    public String save() {
        System.out.println("2");
        Member member = new Member();
        String memberId = UUID.randomUUID().toString().replaceAll("-", "");
        member.setMemberId(memberId);

        return memberRepository.save(member);
    }
}
