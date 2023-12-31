package com.javafranclin.exception;

import java.util.List;

import com.javafranclin.enums.ErrorCodes;

import lombok.Getter;

public class InvalidEntityException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter
	private ErrorCodes errorCodes;

	@Getter
	private List<String> errors;

	public InvalidEntityException(String message) {
		super(message);
	}

	public InvalidEntityException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidEntityException(String message, Throwable cause, ErrorCodes errorCodes) {
		super(message, cause);
		this.errorCodes = errorCodes;
	}

	public InvalidEntityException(String message, ErrorCodes errorCodes) {
		super(message);
		this.errorCodes = errorCodes;
	}

	public InvalidEntityException(String message, ErrorCodes errorCodes, List<String> errors) {
		super(message);
		this.errorCodes = errorCodes;
		this.errors = errors;
	}

}
