package com.generali.userauthservice.restclients.restclientinterface;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientInterfaceService {

    private final IJokeClient client;

    @PostConstruct
    void executeRequestViaInterface(){
        log.info("Interface client response is: {}",client.getRandomJoke());
    }
}
