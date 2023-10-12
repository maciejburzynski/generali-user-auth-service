package com.generali.userauthservice.restclients.webclient;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class GeneraliWebClient {

    WebClient webClient = WebClient.create();


    @PostConstruct
    void executeWebClientHttpRequest() {

        Mono<String> stringMono = webClient.method(HttpMethod.GET)
                .uri("https://official-joke-api.appspot.com/random_joke")
                .cookie("cookie-name", "cookie-value")
                .header("header-name", "header-value")
                .retrieve()
                .bodyToMono(String.class);

        stringMono.subscribe(response -> log.info("WebClient Mono response is: {}", response));
        log.info("1UMC UMC UMC UMC ");

        Flux<String> stringFlux = webClient.method(HttpMethod.GET)
                .uri("https://official-joke-api.appspot.com/random_joke")
                .cookie("cookie-name", "cookie-value")
                .header("header-name", "header-value")
                .retrieve()
                .bodyToFlux(String.class);

        log.info("2UMC UMC UMC UMC");
        stringFlux.subscribe(response -> log.info("WebClient Flux response is: {}", response));
    }
  /*
  Sync
    User -------- Service
    SendRequest ->
                <- SendResponse
    SendAnotherRequest ->
                <- SendAnotherResponse

  Async/Reactive
    User -------- Service
    SendRequest ->
    SendAnotherRequest ->
                <- SendResponse
                <- SendAnotherResponse
    */
}
