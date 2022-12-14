package com.example.todoclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class TodoClientConfig {

    @Value("${todo-client.todo-service.base-url}")
    private String todoServiceBaseUrl;

    @Bean
    WebClient webClient(WebClient.Builder builder) {
        return builder
                .baseUrl(todoServiceBaseUrl)
                .build();
    }

    @Bean
    TodoClient todoClient(WebClient webClient) {
        var factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .build();
        return factory
                .createClient(TodoClient.class);
    }

}
