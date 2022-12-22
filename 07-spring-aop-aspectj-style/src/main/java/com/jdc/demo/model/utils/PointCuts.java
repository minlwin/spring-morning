package com.jdc.demo.model.utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PointCuts {

	@Pointcut("execution(* save(..))")
	public void saveMethod() {}
	
	@Pointcut("within(com.jdc..service.impl.*)")
	public void withinServiceImpl() {}
	
	@Pointcut("withinServiceImpl() && saveMethod()")
	public void serviceSaveMethods() {}
	
	@Pointcut("execution(* findById(..))")
	public void findByIdMethod() {}
	
	@Pointcut("withinServiceImpl() && findByIdMethod()")
	public void serviceFindByIdMethods() {}
}
