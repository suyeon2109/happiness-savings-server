package com.first.happinesssavings.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.first.happinesssavings.domain.Happiness;
import com.first.happinesssavings.dto.*;
import com.first.happinesssavings.repository.HappinessRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@Slf4j
public class HappinessService {
    private static final String BUCKET_NAME = "happysidebucket";

    Logger logger = LoggerFactory.getLogger(HappinessService.class);
    @Autowired
    private HappinessRepository happinessRepository;

    @Autowired
    private AmazonS3 amazonS3;

    @Transactional
    public Long write(String uuid, HappinessCreateDto happinessCreateDto) {
        happinessCreateDto.setMemberUuid(uuid);
        ModelMapper mapper = new ModelMapper();

        String now = LocalDateTime.now().toString();
        LocalDateTime parsedDateTime = LocalDateTime.parse(now.substring(0,now.indexOf(".")), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        happinessCreateDto.setCreatedAt(parsedDateTime);
        happinessCreateDto.setUpdatedAt(parsedDateTime);

        Happiness happiness = mapper.map(happinessCreateDto, Happiness.class);

        String imageUrl = upload(happinessCreateDto.getFile());
        log.info("imageUrl: {}", imageUrl);

        return happinessRepository.save(happiness);
    }

    private String upload(MultipartFile file) {
        String fileName = createFileName(file.getOriginalFilename());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.getSize());
        objectMetadata.setContentType(file.getContentType());

        try (InputStream inputStream = file.getInputStream()) {
            amazonS3.putObject(new PutObjectRequest(BUCKET_NAME, fileName, inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패했습니다.");
        }

        return amazonS3.getUrl(BUCKET_NAME, fileName).toString();
    }

    private String createFileName(String fileName) {
        return UUID.randomUUID().toString().concat(getFileExtension(fileName));
    }

    private String getFileExtension(String fileName) {
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 형식의 파일(" + fileName + ") 입니다.");
        }
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
