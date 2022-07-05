package com.first.happinesssavings;

import com.first.happinesssavings.domain.Member;
import com.first.happinesssavings.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("/signUp")
    public String signUp(Member member) {
        return memberService.signUp(member);
    }
}
