package com.flipkart.oderservice.exception;

public class QuantityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public QuantityException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
