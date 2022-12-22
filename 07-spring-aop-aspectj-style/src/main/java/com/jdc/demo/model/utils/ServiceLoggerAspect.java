package com.jdc.demo.model.utils;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.jdc.demo.model.dto.Course;

@Component
@Aspect
public class ServiceLoggerAspect {
	
	@Before(value = "PointCuts.withinServiceImpl() && args(dto)", argNames = "dto")
	public void beforeExecution(Course course) {
		System.out.println("Before Execution");
		System.out.println(course);
	}
	
	@AfterReturning(
			value = "PointCuts.serviceSaveMethods() && args(input)", 
			argNames = "input,output",
			returning = "output")
	public void afeterReturn(Course input, int output) {
		System.out.println("After Returning Value");
		System.out.println(input);
		System.out.println("Result is %d".formatted(output));
	}
	
	@AfterThrowing(
			pointcut = "PointCuts.serviceSaveMethods() && args(input)",
			throwing = "exception",
			argNames = "input,exception"
			)
	public void afterThrowing(Course input, Throwable exception) {
		System.out.println("After Throwing");
		System.out.println(input);
		System.out.println(exception.getClass());
		System.out.println(exception.getMessage());
	}
}
