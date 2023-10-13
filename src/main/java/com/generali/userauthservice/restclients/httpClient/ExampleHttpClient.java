package com.generali.userauthservice.restclients.httpClient;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.http.HttpClient;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ExampleHttpClient {

    void sendRequest() {
        HttpClient client = HttpClient.newBuilder()
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("username", "password".toCharArray());
                    }
                })
                .connectTimeout(Duration.of(1, ChronoUnit.MILLIS)).build();
//    client.sendAsync()
    }

//    Basic auth -> username:password encoded in Base 64
//    header -> name: "Authentication" value: "Basic <encoded username:password>
}
