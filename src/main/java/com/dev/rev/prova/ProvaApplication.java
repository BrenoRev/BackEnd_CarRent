package com.dev.rev.prova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@EnableCaching
public class ProvaApplication implements WebMvcConfigurer {
	
	public static void main(String[] args) {
		SpringApplication.run(ProvaApplication.class, args);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("**")
				.allowedMethods("POST", "PUT", "GET", "DELETE", "PATCH")
				.allowedOrigins("*");
	}
	}
