package com.cbs.exception;

import org.springframework.http.HttpStatus;

public class CarException extends RuntimeException {

	private HttpStatus httpStatus;
	private String path;

	public CarException(String message, HttpStatus httpStatus, String path) {
		super(message);
		this.httpStatus = httpStatus;
		this.path = path;
	}

	public CarException(String message, HttpStatus httpStatus) {
		super(message);
	}

	public CarException(String message) {
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
