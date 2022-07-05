package com.first.happinesssavings.service;

import com.first.happinesssavings.domain.Happiness;
import com.first.happinesssavings.repository.HappinessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HappinessService {
    @Autowired
    private HappinessRepository happinessRepository;

    @Transactional
    public Long write(Happiness happiness){
        return happinessRepository.save(happiness);
    }

    public Happiness findOne(Happiness happiness){
        return happinessRepository.findOne(happiness);
    }

    public List<Happiness> findAll(String memberId){
        return happinessRepository.findAll(memberId);
    }

    public List<Happiness> findByTitle(Happiness happiness){
        return happinessRepository.findByTitle(happiness);
    }

    public Long count(String memberId){
        return happinessRepository.count(memberId);
    }
}
