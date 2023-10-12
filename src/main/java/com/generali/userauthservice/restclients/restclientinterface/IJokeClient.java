package com.generali.userauthservice.restclients.restclientinterface;

import org.springframework.web.service.annotation.GetExchange;

public interface IJokeClient {

    @GetExchange(url = "/random_joke")
    String getRandomJoke();

}
