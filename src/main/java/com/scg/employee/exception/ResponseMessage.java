package com.scg.employee.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseMessage {

	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String message;
	private String path;

}
