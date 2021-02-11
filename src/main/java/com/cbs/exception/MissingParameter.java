package com.cbs.exception;

public class MissingParameter extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MissingParameter(String message) {
		super(message);
	}

	
}
