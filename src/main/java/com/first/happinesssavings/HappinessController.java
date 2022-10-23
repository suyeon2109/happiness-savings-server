package com.first.happinesssavings;

import com.first.happinesssavings.domain.Happiness;
import com.first.happinesssavings.dto.*;
import com.first.happinesssavings.service.HappinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/members/{uuid}/happiness")
@Slf4j
public class HappinessController {

    @Autowired
    HappinessService happinessService;

    @PostMapping("/write")
    public Long write(@PathVariable String uuid, HappinessCreateDto happinessCreateDto){
        return happinessService.write(uuid, happinessCreateDto);
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

    @GetMapping("/findDailyAvg")
    public List<HappinessIndexDailyAvgResponse> findDailyAvg(@PathVariable String uuid){
        LocalDateTime nowDate = LocalDateTime.now();
        HappinessIndexAvgRequest request = new HappinessIndexAvgRequest(uuid, nowDate);
        List<HappinessIndexDailyAvgResponse> response = happinessService.findDailyAvg(request);
        return happinessService.findDailyAvg(request);
    }

    @GetMapping("/findMonthlyAvg")
    public List<HappinessIndexMonthlyAvgResponse> findMonthlyAvg(@PathVariable String uuid){
        LocalDateTime nowDate = LocalDateTime.now();
        HappinessIndexAvgRequest request = new HappinessIndexAvgRequest(uuid, nowDate);
        List<HappinessIndexMonthlyAvgResponse> response = happinessService.findMonthlyAvg(request);
        return happinessService.findMonthlyAvg(request);
    }
}
