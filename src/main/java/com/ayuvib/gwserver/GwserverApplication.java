package com.ayuvib.gwserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GwserverApplication implements CommandLineRunner {

	public static void main(String[] args) {
		
		System.out.println("Server started");
		SpringApplication.run(GwserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Server running");
	}
}
