package com.ssr.ssr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SsrApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SsrApplication.class, args);
	}

	//access command line arguments
	@Override
	public void run(String... args) throws Exception {

		//do something

	}
}
