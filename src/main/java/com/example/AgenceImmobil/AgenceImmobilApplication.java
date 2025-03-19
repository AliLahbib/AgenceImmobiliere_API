package com.example.AgenceImmobil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.AgenceImmobil.entities")
public class AgenceImmobilApplication {

	public static void main(String[] args) {

		SpringApplication.run(AgenceImmobilApplication.class, args);
	}

}
