package com.jdc.demo.model.utils;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

@Component
public class AfterReturningFIndByIdAdvisor implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Result for Find By Id.");
		System.out.println(returnValue);
	}

}
