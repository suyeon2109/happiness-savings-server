package com.first.happinesssavings;

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

    @PostMapping("/signUp")
    public String save() {
        System.out.println("1");
        return memberService.save();
    }
}
