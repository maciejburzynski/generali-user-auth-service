package com.generali.userauthservice.user;


import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static java.net.URI.create;

@Component
@Slf4j
public class UserActivationClient {

  @Value("${mail-service.url}")
  private String mailServiceUrl;
  @Value("${user-auth-service.url}")
  private String userAuthServiceUrl;


  void activateUser(User user) {
    HttpClient httpClient = HttpClient.newHttpClient();
    HttpRequest httpRequest = HttpRequest
      .newBuilder()
      .header("content-type", "application/json")
      .POST(HttpRequest.BodyPublishers.ofString(String.format(
        """
          {
          "receiver":"%s",
          "subject":"User activation",
          "content":"Please activate user using the link: %s"
          }
          """,
        user.getUsername(),
        userAuthServiceUrl + user.getUuid()
      )))
      .uri(create(mailServiceUrl))
      .build();
    try {
      HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
