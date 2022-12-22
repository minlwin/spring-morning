package com.jdc.demo.model.utils;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.jdc.demo.model.dto.Course;

@Component
@Aspect
public class ServiceLoggerAspect {
	
	@Pointcut("execution(* save(..))")
	public void saveMethod() {}
	
	@Pointcut("within(com.jdc..service.impl.*)")
	public void withinServiceImpl() {}

//	@Before(value = "withinServiceImpl() && args(dto)", argNames = "dto")
//	public void beforeExecution(Course course) {
//		System.out.println("Before Execution");
//		System.out.println(course);
//	}
//	
//	@AfterReturning(
//			value = "withinServiceImpl() && saveMethod() && args(input)", 
//			argNames = "input,output",
//			returning = "output")
//	public void afeterReturn(Course input, int output) {
//		System.out.println("After Returning Value");
//		System.out.println(input);
//		System.out.println("Result is %d".formatted(output));
//	}
//	
	@AfterThrowing(
			pointcut = "withinServiceImpl() && saveMethod() && args(input)",
			throwing = "exception",
			argNames = "input,exception"
			)
	public void afterThrowing(Course input, Throwable exception) {
		System.out.println("After Throwing");
		System.out.println(input);
		System.out.println(exception.getClass());
		exception.printStackTrace();
	}
}
