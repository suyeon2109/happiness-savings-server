package com.first.happinesssavings.service;

import com.first.happinesssavings.domain.Member;
import com.first.happinesssavings.repository.MemberRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    Logger logger = LoggerFactory.getLogger(MemberService.class);
    @Transactional
    public String signUp(Member member) {
        if(checkDuplication(member)==0L){
            return memberRepository.signUp(member);
        } else {
            return "";
        }
    }

    public Long checkDuplication(Member member) {
        return memberRepository.findOne(member);
    }
}
