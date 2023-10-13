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
        Object object = new Object();
        Object anotherObject = object;
        log.info(object.toString());
        log.info(anotherObject.toString());
        log.info("Interface client response is: {}",client.getRandomJoke());
    }
}
