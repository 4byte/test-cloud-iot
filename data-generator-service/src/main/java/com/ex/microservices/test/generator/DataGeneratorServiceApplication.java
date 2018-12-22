package com.ex.microservices.test.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class DataGeneratorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataGeneratorServiceApplication.class, args);
	}
}
