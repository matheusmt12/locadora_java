package com.matheus.locadoraCarro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
	private String message;
	
	public String getMessage() {
		return "texto de menssagem";
	}
	

	@Bean
	public void inite() {
		System.out.println("teste");
	}
}
