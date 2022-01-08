package com.dev.rev.prova;

import com.dev.rev.prova.entities.Test;
import com.dev.rev.prova.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProvaApplication {

	@Autowired
	TestRepository testRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProvaApplication.class, args);
	}

	CommandLineRunner commandLineRunner() {
		return args -> {
				testRepository.save(new Test());
		};
	}
}
