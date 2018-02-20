package com.alican;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class HrappApplication {
	public static void main(String[] args) {
		SpringApplication.run(HrappApplication.class, args);
	}
}
