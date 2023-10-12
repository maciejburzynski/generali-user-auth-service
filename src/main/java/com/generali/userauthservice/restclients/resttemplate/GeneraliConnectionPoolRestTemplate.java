package com.generali.userauthservice.restclients.resttemplate;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
@Slf4j
public class GeneraliConnectionPoolRestTemplate {


    @PostConstruct
    void executeConnectionPool() throws IOException {


        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        poolingHttpClientConnectionManager.setMaxTotal(100);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(10);

        CloseableHttpClient client = HttpClients.custom()
                .setConnectionManager(poolingHttpClientConnectionManager)
                .build();

        CloseableHttpResponse closeableHttpResponse = client.execute(new HttpGet("https://official-joke-api.appspot.com/random_joke"));
        String response = new BasicResponseHandler().handleResponse(closeableHttpResponse);

        log.info("Connection Pool response: {}",response);


    }
}
