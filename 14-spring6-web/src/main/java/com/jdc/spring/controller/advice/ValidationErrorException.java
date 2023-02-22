package com.jdc.spring.controller.advice;

import java.util.List;

import org.springframework.validation.FieldError;

public class ValidationErrorException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private List<FieldError> errors;

	public ValidationErrorException(List<FieldError> errors) {
		super();
		this.errors = errors;
	}
	
	public List<FieldError> getErrors() {
		return errors;
	}

}
