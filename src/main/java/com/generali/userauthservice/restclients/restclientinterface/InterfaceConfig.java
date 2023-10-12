package com.generali.userauthservice.restclients.restclientinterface;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class InterfaceConfig {

    @Bean
    IJokeClient iJokeClient(){
        WebClient webClient = WebClient.builder()
                .baseUrl("https://official-joke-api.appspot.com")
                .defaultHeader("header-name", "header-value")
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .build();

        return factory.createClient(IJokeClient.class);
    }
}
