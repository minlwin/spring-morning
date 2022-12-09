package com.jdc.demo.utils;

import org.aspectj.lang.JoinPoint;
import org.springframework.context.annotation.Configuration;

import com.jdc.demo.dao.dto.Account;

@Configuration
public class ContexualAspect {

	public void beforeProxy(JoinPoint joinPoint) {
		System.out.println("Before Proxy Advice");
	}
	
	public void beforeTarget(JoinPoint joinPoint) {

		System.out.println("Before Target Advice");
		System.out.printf("%-12s : %s%n", "Kind", joinPoint.getKind());
		System.out.printf("%-12s : %s%n", "Type", joinPoint.getSignature().getDeclaringTypeName());
		System.out.printf("%-12s : %s%n", "Method", joinPoint.getSignature().getName());
		System.out.printf("%-12s : %s%n", "Modifier", joinPoint.getSignature().getModifiers());
		
		var args = joinPoint.getArgs();
		System.out.println("Arguments");
		System.out.println("--------------------------");
		for(var i = 0; i < args.length; i ++) {
			System.out.println("%d. %s".formatted(i + 1, args[i]));
		}
	}
	
	public void getException(IllegalArgumentException ex) {
		System.out.println(ex.getClass().getName());
	}
	
	public void getReturnValue(Account input, int ouput) {
		System.out.println(input);
		System.out.println("Return Value is %d.".formatted(ouput));
	}
}
