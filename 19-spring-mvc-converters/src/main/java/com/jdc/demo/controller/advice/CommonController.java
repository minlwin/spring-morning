package com.jdc.demo.controller.advice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import com.jdc.demo.controller.validator.SessionValidator;

@ControllerAdvice
public class CommonController {

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(new SessionValidator());
	}
}
