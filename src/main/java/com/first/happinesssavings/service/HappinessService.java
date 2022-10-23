package com.first.happinesssavings.service;

import com.first.happinesssavings.domain.Happiness;
import com.first.happinesssavings.dto.*;
import com.first.happinesssavings.repository.HappinessRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
public class HappinessService {

    Logger logger = LoggerFactory.getLogger(HappinessService.class);
    @Autowired
    private HappinessRepository happinessRepository;

    @Autowired
    private FileService fileService;

    @Transactional
    public Long write(String uuid, HappinessCreateDto happinessCreateDto) {
        happinessCreateDto.setMemberUuid(uuid);
        ModelMapper mapper = new ModelMapper();

        String now = LocalDateTime.now().toString();
        LocalDateTime parsedDateTime = LocalDateTime.parse(now.substring(0,now.indexOf(".")), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        happinessCreateDto.setCreatedAt(parsedDateTime);
        happinessCreateDto.setUpdatedAt(parsedDateTime);

        Happiness happiness = mapper.map(happinessCreateDto, Happiness.class);

        String imageUrl = fileService.upload(happinessCreateDto.getFile());
        log.info("imageUrl: {}", imageUrl);

        return happinessRepository.save(happiness);
    }

    public Happiness findOne(HappinessFindOneDto happinessFindOneDto) {
        return happinessRepository.findOne(happinessFindOneDto);
    }

    public List<Happiness> findAll(String memberUuid) {
        return happinessRepository.findAll(memberUuid);
    }

    public List<Happiness> findByTitle(HappinessFindByTitleDto happinessFindByTitleDto) {
        return happinessRepository.findByTitle(happinessFindByTitleDto);
    }

    public Long count(String memberUuid) {
        return happinessRepository.count(memberUuid);
    }

    public List<HappinessIndexDailyAvgResponse> findDailyAvg(HappinessIndexAvgRequest request){
        String now = LocalDateTime.now().toString();
        LocalDateTime parsedDateTime = LocalDateTime.parse(now.substring(0,now.indexOf(".")), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        request.setNow(parsedDateTime);
        return happinessRepository.findDailyAvg(request);
    }

    public List<HappinessIndexMonthlyAvgResponse> findMonthlyAvg(HappinessIndexAvgRequest request){
        String now = LocalDateTime.now().toString();
        LocalDateTime parsedDateTime = LocalDateTime.parse(now.substring(0,now.indexOf(".")), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        request.setNow(parsedDateTime);
        return happinessRepository.findMonthlyAvg(request);
    }

}
