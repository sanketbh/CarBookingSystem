package com.cbs.exception;

import org.springframework.http.HttpStatus;

public class BookingException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private HttpStatus httpStatus;
	private String path;

	public BookingException(String message, HttpStatus httpStatus, String path) {
		super(message);
		this.httpStatus = httpStatus;
		this.path = path;
	}

	public BookingException(String message, HttpStatus httpStatus) {
		super(message);
	}

	public BookingException(String message) {
		super(message);
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
