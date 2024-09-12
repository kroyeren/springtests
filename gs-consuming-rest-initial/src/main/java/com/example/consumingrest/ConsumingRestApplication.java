package com.example.consumingrest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	@Profile("!test")
	public CommandLineRunner run(RestTemplate  restTemplate) throws Exception {
		return args -> {
			Instrument instrument = restTemplate.getForObject("http://172.31.2.94:3098/?instrumentid=0000012", Instrument.class);
			System.out.println(instrument.toString());
		};
		
	}
}
