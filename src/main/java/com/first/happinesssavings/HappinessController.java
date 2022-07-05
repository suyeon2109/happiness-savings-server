package com.first.happinesssavings;

import com.first.happinesssavings.domain.Happiness;
import com.first.happinesssavings.service.HappinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members/{memberId}/happiness")
public class HappinessController {

    @Autowired
    HappinessService happinessService;

    @PostMapping("/write")
    public Long write(@PathVariable String memberId, Happiness happiness){
        happiness.setMemberId(memberId);
        return happinessService.write(happiness);
    }

    @GetMapping("/findOne")
    public Happiness findOne(@PathVariable String memberId, Long id){
        Happiness happiness = new Happiness();
        happiness.setMemberId(memberId);
        happiness.setId(id);
        return happinessService.findOne(happiness);
    }

    @GetMapping("/findAll")
    public List<Happiness> findAll(@PathVariable String memberId) {
        return happinessService.findAll(memberId);
    }

    @GetMapping("/findByTitle")
    public List<Happiness> findByTitle(@PathVariable String memberId, String title) {
        Happiness happiness = new Happiness();
        happiness.setMemberId(memberId);
        happiness.setTitle(title);
        return happinessService.findByTitle(happiness);
    }

    @GetMapping("/count")
    public Long count(@PathVariable String memberId) {
        return happinessService.count(memberId);
    }
}
