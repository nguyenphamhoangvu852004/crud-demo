package com.gdu_crud_demo.crud_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Connect to database successfully");
		};
	}
}
