package com.first.happinesssavings;

import com.first.happinesssavings.domain.Member;
import com.first.happinesssavings.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("/singUp")
    public String save(Member member) {
        return memberService.save(member);
    }
}
