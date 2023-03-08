package com.jdc.spring.controller.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdc.spring.model.dto.MessageDto;
import com.jdc.spring.model.dto.MessageDto.Status;

@RestControllerAdvice
public class ValidationErrorAdvice {

	@ExceptionHandler(value = ValidationErrorException.class)
	MessageDto handle(ValidationErrorException e) {
		return new MessageDto(Status.Business, e.getMessages());
	}
}
