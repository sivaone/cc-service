package com.cch.cloudchasers.cch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.cch.cloudchasers.cch")
public class CchApplication {

	public static void main(String[] args) {
		SpringApplication.run(CchApplication.class, args);
	}
}
