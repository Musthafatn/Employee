package com.scg.employee.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DataNotFoundExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
	public String handleDataNotFoundException(final DataNotFoundException e) {

//		final ResponseMessage responseMessage = new ResponseMessage(e.getMessage());
//		return responseMessage;

		return e.getMessage();

	}

}