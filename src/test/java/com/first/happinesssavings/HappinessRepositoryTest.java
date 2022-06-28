package com.first.happinesssavings;

import com.first.happinesssavings.domain.Happiness;
import com.first.happinesssavings.repository.HappinessRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class HappinessRepositoryTest {

    @Autowired
    HappinessRepository happinessRepository;

    @Test
    @Transactional
//    @Rollback(value = false)
    void testHappiness() {
        // given
        Happiness happiness = new Happiness();
        happiness.setTitle("테스트");
        happiness.setContent("내용 테스트");

        // when
        Long seq = happinessRepository.save(happiness);
        Happiness findOne = happinessRepository.findOne(seq);

        //then
        Assertions.assertThat(findOne.getSeq()).isEqualTo(happiness.getSeq());
        Assertions.assertThat(findOne.getContent()).isEqualTo(happiness.getContent());
    }

}