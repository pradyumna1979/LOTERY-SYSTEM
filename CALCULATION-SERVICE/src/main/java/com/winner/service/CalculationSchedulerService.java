package com.winner.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.winner.dto.Lotery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CalculationSchedulerService {
    private RestTemplate restTemplate;
    @Value("${lotery.filepath}")
    private String loteryFilePath;
    @Value("${winnerService.url}")
    private String winnerServiceUrl;
    public CalculationSchedulerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
   @Scheduled(cron = "0 0 0 * * *")
   //Second,Min,Hour,Day,Month,year
    public Lotery save() throws IOException {
        log.info("INside CalculationSchedulerService::save");
        ObjectMapper mapper = new ObjectMapper();

        //JSON file to Java object
        Lotery lotery = mapper.readValue(new File(loteryFilePath), Lotery.class);

        HttpEntity< Lotery> loteryHttpEntity= new HttpEntity<>(lotery);
        return restTemplate.exchange(winnerServiceUrl, HttpMethod.POST,loteryHttpEntity,Lotery.class).getBody();
    }
}
