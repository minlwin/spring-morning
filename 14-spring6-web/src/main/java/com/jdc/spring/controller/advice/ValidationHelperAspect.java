package com.jdc.spring.controller.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Aspect
@Component
public class ValidationHelperAspect {
	
	@Before(value = "@within(org.springframework.web.bind.annotation.RestController) && args(..,result)", argNames = "result")
	public void inspact(BindingResult result) {
		if(result.hasErrors()) {
			throw new ValidationErrorException(result.getFieldErrors());
		}		
	}
}
