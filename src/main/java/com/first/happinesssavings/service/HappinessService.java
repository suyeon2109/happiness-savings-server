package com.first.happinesssavings.service;

import com.first.happinesssavings.domain.Happiness;
import com.first.happinesssavings.dto.HappinessDto;
import com.first.happinesssavings.dto.HappinessFindByTitleDto;
import com.first.happinesssavings.dto.HappinessFindOneDto;
import com.first.happinesssavings.repository.HappinessRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class HappinessService {
    Logger logger = LoggerFactory.getLogger(HappinessService.class);
    @Autowired
    private HappinessRepository happinessRepository;

    @Transactional
    public Long write(String uuid, HappinessDto happinessDto) {
        happinessDto.setMemberUuid(uuid);
        ModelMapper mapper = new ModelMapper();
        Happiness happiness = mapper.map(happinessDto, Happiness.class);

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
}
