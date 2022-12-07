package com.jdc.demo.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerAspect {

	public void beforeExecution() {
		System.out.println("Start Dao Method");
	}
	
	public void afterExecution() {
		System.out.println("After Execution of Business Method");
	}
	
	public void afterReturning() {
		System.out.println("After Returning Business Method");
	}
	
	public void afterThrowing() {
		System.out.println("After Throwing Exception");
	}
	
	public Object aroundInvoke(ProceedingJoinPoint joinPoint) {
		Object result = null;
		
		try {
			
			// Before Invocation
			
			result = joinPoint.proceed();
			
			// After Returning
		} catch (Throwable e) {
			// After Throwing
			throw new RuntimeException(e);
		} finally {
			// After
		}
		
		return result;
	}
}
