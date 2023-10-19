package com.generali.userauthservice.user;


import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static java.net.URI.create;

@Service
@Slf4j
public class UserActivationClient {

  @Value("${mail-service.url}")
  private String baseUrl;
  private String url = baseUrl + "/api/mails";


  void activateUser(User user) throws IOException, InterruptedException {
    HttpClient httpClient = HttpClient.newHttpClient();
    HttpRequest httpRequest = HttpRequest
      .newBuilder()
      .POST(HttpRequest.BodyPublishers.ofString(String.format(
        """
          {
          "receiver":"%s",
          "subject":"User activation",
          "content":"Please activate user: %s"
          }
          """, user.getUsername()
      )))
      .uri(create(url))
      .build();
    HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());


    log.info(httpResponse.body().toString());
  }
}
