package com.first.happinesssavings;

import com.first.happinesssavings.domain.Happiness;
import com.first.happinesssavings.dto.HappinessFindByTitleDto;
import com.first.happinesssavings.dto.HappinessFindOneDto;
import com.first.happinesssavings.service.HappinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members/{uuid}/happiness")
public class HappinessController {

    @Autowired
    HappinessService happinessService;

    @PostMapping("/write")
    public Long write(@PathVariable String uuid, Happiness happiness){
        return happinessService.write(uuid, happiness);
    }

    @GetMapping("/findOne")
    public Happiness findOne(@PathVariable String uuid, Long id){
        HappinessFindOneDto happinessFindOneDto = new HappinessFindOneDto(uuid, id);
        return happinessService.findOne(happinessFindOneDto);
    }

    @GetMapping("/findAll")
    public List<Happiness> findAll(@PathVariable String uuid) {
        return happinessService.findAll(uuid);
    }

    @GetMapping("/findByTitle")
    public List<Happiness> findByTitle(@PathVariable String uuid, String title) {
        HappinessFindByTitleDto happinessFindByTitleDto = new HappinessFindByTitleDto(uuid, title);
        return happinessService.findByTitle(happinessFindByTitleDto);
    }

    @GetMapping("/count")
    public Long count(@PathVariable String uuid) {
        return happinessService.count(uuid);
    }
}
