package com.first.happinesssavings;

import com.first.happinesssavings.domain.Happiness;
import com.first.happinesssavings.service.HappinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/happy")
public class HappinessController {

    @Autowired
    HappinessService happinessService;

    @GetMapping("/hello")
    public void hello(){
    }

    @GetMapping("/write")
    public Long write(Happiness happiness){
        return happinessService.write(happiness);
    }

    @GetMapping("/findOne")
    public Happiness findOne(Long seq){
        return happinessService.findOne(seq);
    }

    @GetMapping("/findAll")
    public List<Happiness> findAll() {
        return happinessService.findAll();
    }

    @GetMapping("/findByTitle")
    public List<Happiness> findByTitle(String title) {
        return happinessService.findByTitle(title);
    }
}
