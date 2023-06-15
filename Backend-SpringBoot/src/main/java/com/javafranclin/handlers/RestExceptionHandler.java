package com.javafranclin.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javafranclin.exception.InvalidEntityException;
import com.javafranclin.exception.EntityNotFoundException;
import com.javafranclin.exception.InvalidOperationException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErreurDTo> handleException(EntityNotFoundException exception, WebRequest webRequest) {

		final HttpStatus notFound = HttpStatus.NOT_FOUND;
		final ErreurDTo erreurDTo = new ErreurDTo();
		erreurDTo.setCode(exception.getErrorCodes());
		erreurDTo.setHttpCode(notFound.value());
		erreurDTo.setMessage(exception.getMessage());

		return new ResponseEntity<>(erreurDTo, notFound);
	}

	@ExceptionHandler(InvalidEntityException.class)
	public ResponseEntity<ErreurDTo> handleException(InvalidEntityException exception, WebRequest webRequest) {

		final HttpStatus bandeRequest = HttpStatus.BAD_REQUEST;
		final ErreurDTo erreurDTo = new ErreurDTo();
		erreurDTo.setCode(exception.getErrorCodes());
		erreurDTo.setHttpCode(bandeRequest.value());
		erreurDTo.setMessage(exception.getMessage());
		erreurDTo.setErrors(exception.getErrors());

		return new ResponseEntity<>(erreurDTo, bandeRequest);

	}

	@ExceptionHandler(InvalidOperationException.class)
	public ResponseEntity<ErreurDTo> handleException(InvalidOperationException exception, WebRequest webRequest) {

		final HttpStatus bandeRequest = HttpStatus.BAD_REQUEST;
		final ErreurDTo erreurDTo = new ErreurDTo();

		erreurDTo.setCode(exception.getErrorCodes());
		erreurDTo.setHttpCode(bandeRequest.value());
		erreurDTo.setMessage(exception.getMessage());

		return new ResponseEntity<>(erreurDTo, bandeRequest);

	}
	
	/*
	 * @ExceptionHandler(BadCredentialsException.class) public
	 * ResponseEntity<ErreurDTo> handleException(BadCredentialsException exception,
	 * WebRequest webRequest) {
	 * 
	 * final HttpStatus bandeRequest = HttpStatus.BAD_REQUEST; final ErreurDTo
	 * erreurDTo = new ErreurDTo();
	 * 
	 * erreurDTo.setCode(ErrorCodes.BAD_CREDENTIALS);
	 * erreurDTo.setHttpCode(bandeRequest.value());
	 * erreurDTo.setMessage(exception.getMessage());
	 * erreurDTo.setErrors(Collections.
	 * singletonList("Login et / ou mot de passe incorrecte"));
	 * 
	 * return new ResponseEntity<>(erreurDTo, bandeRequest);
	 * 
	 * }
	 */
}
