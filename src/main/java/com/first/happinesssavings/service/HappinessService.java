package com.first.happinesssavings.service;

import com.first.happinesssavings.domain.Happiness;
import com.first.happinesssavings.dto.HappinessFindByTitleDto;
import com.first.happinesssavings.dto.HappinessFindOneDto;
import com.first.happinesssavings.repository.HappinessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class HappinessService {
    @Autowired
    private HappinessRepository happinessRepository;

    @Transactional
    public Long write(String uuid, Happiness happiness){
        happiness.setMemberUuid(uuid);
        return happinessRepository.save(happiness);
    }

    public Happiness findOne(HappinessFindOneDto happinessFindOneDto){
        return happinessRepository.findOne(happinessFindOneDto);
    }

    public List<Happiness> findAll(String memberUuid){
        return happinessRepository.findAll(memberUuid);
    }

    public List<Happiness> findByTitle(HappinessFindByTitleDto happinessFindByTitleDto){
        return happinessRepository.findByTitle(happinessFindByTitleDto);
    }

    public Long count(String memberUuid){
        return happinessRepository.count(memberUuid);
    }
}
