package com.generali.userauthservice.user;


import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

import com.generali.userauthservice.jwt.JwtCache;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static java.net.URI.create;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserActivationClient {

<<<<<<< HEAD
  @Value("${user-auth-service.url}")
  private String userAuthServiceUrl;

  @Value("${mail-service.url}")
  private String mailServiceUrl;
  @Value("${mail-service.username}")
  private String mailServiceUsername;
  @Value("${mail-service.password}")
  private String mailServicePassword;
=======
  @Value("${mail-service.url}")
  private String mailServiceUrl;
  @Value("${user-auth-service.url}")
  private String userAuthServiceUrl;

  private final JwtCache jwtCache;
>>>>>>> 850a6a326d91534959a637e7eb7d1c0a81a1f3ba

  void activateUser(User user) {
    HttpClient httpClient = HttpClient.newHttpClient();
    HttpRequest httpRequest = HttpRequest
      .newBuilder()
      .header("content-type", "application/json")
<<<<<<< HEAD
      .header("Authorization","Basic " + Base64.getEncoder().encodeToString((mailServiceUsername+":"+mailServicePassword).getBytes()))
=======
      .header("Authorization","Bearer " + jwtCache.getToken())
>>>>>>> 850a6a326d91534959a637e7eb7d1c0a81a1f3ba
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
      log.info(httpResponse.toString());
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
