package com.playground.demo.springsleuth.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfig {

    @Bean(name = "restClient")
    public RestTemplate restClient() {
        return new RestTemplate();
    }

}