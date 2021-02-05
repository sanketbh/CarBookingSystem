package com.cbs.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cbs.exception.NotFoundException;

//centralize exception handler
@ControllerAdvice
public class CarBookingSystemExceptionHandler {

	// Not Found Exception handler
	@ExceptionHandler(value = { NotFoundException.class })
	public ResponseEntity<ErrorResponse> NotFoundExceptionHandler(NotFoundException e) {
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(httpStatus.value());
		errorResponse.setErrorMessage(e.getLocalizedMessage());
		return ResponseEntity.status(httpStatus).body(errorResponse);
	}
}
