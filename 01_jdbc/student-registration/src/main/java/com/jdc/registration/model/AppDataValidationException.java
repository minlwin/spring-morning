package com.jdc.registration.model;

import java.util.List;

public class AppDataValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private List<String> messages;

	public AppDataValidationException(List<String> messages) {
		super();
		this.messages = messages;
	}

	public AppDataValidationException(String message, Throwable cause) {
		super(message, cause);
		messages = List.of(message);
	}

	public AppDataValidationException(String message) {
		super(message);
		messages = List.of(message);
	}

	public AppDataValidationException(Throwable cause) {
		super(cause);
	}

	public List<String> getMessages() {
		return messages;
	}
}
