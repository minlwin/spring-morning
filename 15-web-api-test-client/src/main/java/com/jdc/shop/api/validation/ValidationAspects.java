package com.jdc.shop.api.validation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Aspect
@Component
public class ValidationAspects {

	@Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
	public void apiMethods() {}
	
	@Before(value = "apiMethods() && args(.., result)", argNames = "result")
	public void handle(BindingResult result) {
		if(result.hasErrors()) {
			throw new ValidationException(result.getFieldErrors());
		}
	}
}
