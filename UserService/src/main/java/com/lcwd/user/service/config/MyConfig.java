package com.lcwd.user.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /*@Bean
    public HttpMessageConverter restTemplate(){
        return new HttpMessageConverter();
    }*/
}
