package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Microservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice2Application.class, args);
	}

    @Bean
    RestTemplate restTemplate(){
	        return new RestTemplate();
	    }
}
