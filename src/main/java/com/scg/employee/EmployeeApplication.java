package com.scg.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EmployeeApplication {

	public static void main(final String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);

	}

}
