package com.generali.userauthservice.restclients.resttemplate;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class RestTemplateService {

//
//    @PostConstruct
//    void executeHttpRequestUsingRestTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        String response = restTemplate.getForObject("https://official-joke-api.appspot.com/random_joke", String.class);
//        log.info("Simple rest template response is: {}", response);
//
//        RestTemplate restTemplateWithParameters = new RestTemplate();
//        String responseWithParameters = restTemplateWithParameters.getForObject("https://api.nationalize.io/?name={name}", String.class, "maciej");
//        log.info("Simple rest template with parameter response is: {}", responseWithParameters);
//
//        RequestEntity requestEntity = RequestEntity
//                .get("https://official-joke-api.appspot.com/random_joke")
//                .header("header-name", "header-value")
//                .build();
//
//        RestTemplate restTemplateWithRequestEntity = new RestTemplate();
//        ResponseEntity responseEntity = restTemplateWithRequestEntity.exchange(requestEntity, String.class);
//        log.info("Response from RequestEntity is: {}",responseEntity.getBody());
//
//
//        // -> Thread per request -> costs a lot of resources (e.g. CPU)
////        no built-in connection pools
//
//
//
//
//
//
//    }
}
