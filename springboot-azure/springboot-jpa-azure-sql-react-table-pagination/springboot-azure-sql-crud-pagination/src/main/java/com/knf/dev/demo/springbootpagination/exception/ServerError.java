package com.knf.dev.demo.springbootpagination.exception;

public class ServerError extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServerError(String message) {
		super(message);
	}

}
