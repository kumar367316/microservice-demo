package com.flipkart.productservice.exception;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;

	public DataNotFoundException(String message) {
		this.message = message;
	}

}
