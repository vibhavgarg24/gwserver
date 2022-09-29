package com.ayuvib.gwserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GwserverApplication implements CommandLineRunner {

	// @Autowired
	// private TestDao testDao;

	public static void main(String[] args) {
		SpringApplication.run(GwserverApplication.class, args);
		System.out.println("Server started");
	}

	@Override
	public void run(String... args) throws Exception {
		
		// int i = this.testDao.getData();
		// System.out.println(i);

		System.out.println("Server running");
	}
}
