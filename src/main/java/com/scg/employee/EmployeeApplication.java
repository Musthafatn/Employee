package com.scg.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(final String[] args) throws Exception {
		SpringApplication.run(EmployeeApplication.class, args);

	}

}

// ./gradlew clean  build -x test to get mapStruct

// @RequestMapping("/employee") , /list
// dao.entity- entity shold be inside dao
// create vo class
// from dao return employeeVO to service
// add pagesize in yml file
// create class employeeMapper, add methods toEntity, toVO
// create dept class and connect with foreign key
// use many to one relationship-   fetchtype: eager,lazy
// create class audit with @embeddable
// use in employee @embedded implements auditable
// spring annotation: @Qualifier, @Primary
// add enum for status
// enitylistener in jpa- need not to code
// create list of map in java Map<Integer, List<String>   put(deptId,empname)