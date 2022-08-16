package com.first.happinesssavings;

import com.first.happinesssavings.domain.Happiness;
import com.first.happinesssavings.dto.HappinessDto;
import com.first.happinesssavings.dto.HappinessFindOneDto;
import com.first.happinesssavings.repository.HappinessRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Slf4j
class HappinessRepositoryTest {

    @Autowired
    HappinessRepository happinessRepository;

    @Test
    @Transactional
//    @Rollback(value = false)
    void testHappiness() {
        Logger log = LoggerFactory.getLogger(HappinessRepositoryTest.class);
        // given
        HappinessDto happinessDto = new HappinessDto();
        happinessDto.setTitle("테스트");
        happinessDto.setContent("내용 테스트");
        happinessDto.setMemberUuid("memberId1");
        happinessDto.setHappinessIndex(50);

        HappinessFindOneDto happinessFindOneDto = new HappinessFindOneDto("memberId1", 1L);

        // when
        Happiness happiness = new ModelMapper().map(happinessDto, Happiness.class);
        Long id = happinessRepository.save(happiness);
        Happiness findOne = happinessRepository.findOne(happinessFindOneDto);

        log.info("id : {}", id);
        log.info("findOne : {}", findOne.toString());

        //then
        Assertions.assertThat(findOne.getId()).isEqualTo(happiness.getId());
        Assertions.assertThat(findOne.getContent()).isEqualTo(happiness.getContent());
    }

}