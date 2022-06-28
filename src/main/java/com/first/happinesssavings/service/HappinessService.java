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

    public Happiness findOne(Long seq){
        return happinessRepository.findOne(seq);
    }

    public List<Happiness> findAll(){
        return happinessRepository.findAll();
    }

    public List<Happiness> findByTitle(String title){
        return happinessRepository.findByTitle(title);
    }

//    public Long count(){
//
//    }
}
