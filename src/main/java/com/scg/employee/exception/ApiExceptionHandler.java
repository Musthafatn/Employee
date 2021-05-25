package com.scg.employee.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(ApiException.class)
	public ResponseMessage handleApiException(final ApiException e) {

		final HttpStatus status = HttpStatus.NOT_FOUND;
		return new ResponseMessage(LocalDateTime.now(), status.value(), status.name(), e.getMessage(), "/employee/");

	}

	@ExceptionHandler(Exception.class)
	public ResponseMessage handleException(final Exception e) {

		final HttpStatus status = HttpStatus.BAD_REQUEST;
		return new ResponseMessage(LocalDateTime.now(), status.value(), status.name(), e.getMessage(), "/employee/");

	}

}