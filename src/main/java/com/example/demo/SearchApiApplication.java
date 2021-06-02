package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={
"com.example.controller", "com.example.service", "com.example.models", "com.example.repo", "com.example.servece.imp"})
@EntityScan("com.example.models")
@EnableJpaRepositories(basePackages= "com.example.repo")
public class SearchApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchApiApplication.class, args);
	}

}
