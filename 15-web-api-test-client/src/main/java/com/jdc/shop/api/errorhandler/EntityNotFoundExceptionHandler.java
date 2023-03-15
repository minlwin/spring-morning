package com.jdc.shop.api.errorhandler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jdc.shop.model.dto.Message;
import com.jdc.shop.model.dto.Message.Status;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class EntityNotFoundExceptionHandler {

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@ExceptionHandler(EntityNotFoundException.class)
	Message handle(EntityNotFoundException ex) {
		return new Message(Status.Business, List.of(ex.getMessage()));
	}
}
