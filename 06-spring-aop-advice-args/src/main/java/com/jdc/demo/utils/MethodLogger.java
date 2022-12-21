package com.jdc.demo.utils;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MethodLogger implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		try {
			
			// Before Advice
			System.out.println("Before Execution of %s".formatted(invocation.getMethod().getName()));
			
			var result = invocation.proceed();
			
			// After Returning Advice
			System.out.println("After Execution of %s".formatted(invocation.getMethod().getName()));
			
			return result;
		} catch (Exception e) {
			// After Throwing
			System.out.println("After Throwing of %s".formatted(invocation.getMethod().getName()));
			throw e;
		} finally {
			// After Finally
			System.out.println("After Finally of %s".formatted(invocation.getMethod().getName()));
		}
	}

}
