package com.first.happinesssavings;

import com.first.happinesssavings.domain.Member;
import com.first.happinesssavings.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     * uuid 로 회원가입
     */
    @PostMapping("/signUp")
    public Long signUp() {
        return memberService.signUp().getMemberId();
    }

    @PostMapping("/login")
    public Long login(@RequestBody LoginRequestDto loginRequestDto) {
        Member member = memberService.getOrCreate(
                loginRequestDto.getIdProviderType(),
                loginRequestDto.getIdProviderUserId()
        );
        return member.getMemberId();
    }
}
