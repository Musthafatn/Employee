package com.scg.employee.exception;

public class ApiException extends RuntimeException {

	public ApiException(final BaseCode errorCode) {
		super(errorCode.getMessage());
	}

}
