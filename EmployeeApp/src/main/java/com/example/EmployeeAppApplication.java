package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAppApplication.class, args);
		System.out.println("Application is Started Successfully...");
	}

}
