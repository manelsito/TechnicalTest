package com.app.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodOsSpringApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TodOsSpringApplication.class, args);

	}

	/**
	 * Show the users
	 */
	@Override
	public void run(String... args) throws Exception {

        System.out.println("User: Manel, Password: 1234");

        System.out.println("User: Alberto, Password: password123");

        System.out.println("User: MariaL, Password: pass456");

        System.out.println("User: johnsmith, Password: abc123");

        System.out.println("User: laurag, Password: abc123");


	}

}
