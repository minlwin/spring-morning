package com.jdc.shop.api.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdc.shop.model.dto.Message;
import com.jdc.shop.model.dto.Message.Status;

@RestControllerAdvice
public class ValidationExceptionHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = ValidationException.class)
	public Message handle(ValidationException e) {
		return new Message(Status.Validation, e.getErrors());
	}
}
