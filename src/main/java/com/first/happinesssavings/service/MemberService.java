package com.first.happinesssavings.service;

import com.first.happinesssavings.domain.Member;
import com.first.happinesssavings.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Transactional
    public String save(Member member) {
        return memberRepository.save(member);
    }
}
