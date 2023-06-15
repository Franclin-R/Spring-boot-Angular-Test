package com.javafranclin.exception;

import com.javafranclin.enums.ErrorCodes;

import lombok.Getter;

public class InvalidOperationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter
	private ErrorCodes errorCodes;

	public InvalidOperationException(String message) {
		super(message);
	}

	public InvalidOperationException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidOperationException(String message, Throwable cause, ErrorCodes errorCodes) {
		super(message, cause);
		this.errorCodes = errorCodes;
	}

	public InvalidOperationException(String message, ErrorCodes errorCodes) {
		super(message);
		this.errorCodes = errorCodes;
	}

}
