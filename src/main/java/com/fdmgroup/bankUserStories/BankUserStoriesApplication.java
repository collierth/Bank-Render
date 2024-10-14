package com.fdmgroup.bankUserStories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdmgroup.bankUserStories.webClient.GeoCoderWebClient;

@SpringBootApplication
public class BankUserStoriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankUserStoriesApplication.class, args);
	}
	
	@Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
    
    @Bean
    public GeoCoderWebClient geoCoderWebClient(WebClient webClient) {
        return new GeoCoderWebClient(webClient);
    }


}
