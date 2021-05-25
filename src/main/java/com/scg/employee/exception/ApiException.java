package com.scg.employee.exception;

public class ApiException extends RuntimeException {

	public ApiException(final ErrorCode errorCode) {
		super(errorCode.getMessage());
	}

}
