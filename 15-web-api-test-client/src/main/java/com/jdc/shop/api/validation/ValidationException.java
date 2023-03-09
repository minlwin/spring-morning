package com.jdc.shop.api.validation;

import java.util.List;

import org.springframework.validation.FieldError;

public class ValidationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private List<FieldError> fieldErrors;

	public ValidationException(List<FieldError> fieldErrors) {
		super();
		this.fieldErrors = fieldErrors;
	}
	
	public List<String> getErrors() {
		return null == fieldErrors ? List.of() :
			fieldErrors.stream().map(FieldError::getDefaultMessage).toList();
	}
}
