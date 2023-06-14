package com.example.todoclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@SpringBootApplication
public class TodoClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoClientApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(TodoClient todoClient) {
		return args -> todoClient
				.getTodos(Map.of("X-REQUEST-SPECIFIC", "HEADER-VALUE"))
				.subscribe(System.out::println);
	}

}
