package com.scg.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EmployeeApplication {

	@SuppressWarnings("resource")
	public static void main(final String[] args) throws Exception {
		SpringApplication.run(EmployeeApplication.class, args);

	}

}
