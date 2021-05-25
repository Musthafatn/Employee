package com.scg.employee.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode  {

	EMPLOYEE_NOT_FOUND("No employee with this id"), 
	DEPT_NOT_FOUND("No department with this id"),
	NO_DATA_FOUND("No data found"),
	INVALID_ID("Invalid id"),
	INVALID_NAME("Invalid name"),
	INVALID_AGE("Invalid age"),
	INVALID_SALARY("Invalid salary"),
	INVALID_PAGE("Invalid page number");

	private String message;

}
