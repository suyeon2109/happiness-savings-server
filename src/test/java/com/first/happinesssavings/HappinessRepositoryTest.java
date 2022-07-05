package com.first.happinesssavings;

import com.first.happinesssavings.domain.Happiness;
import com.first.happinesssavings.repository.HappinessRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;


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
        happiness.setMemberId("memberId1");

        // when
        Long id = happinessRepository.save(happiness);
        Happiness findOne = happinessRepository.findOne(happiness);

        //then
        Assertions.assertThat(findOne.getId()).isEqualTo(happiness.getId());
        Assertions.assertThat(findOne.getContent()).isEqualTo(happiness.getContent());
    }

}