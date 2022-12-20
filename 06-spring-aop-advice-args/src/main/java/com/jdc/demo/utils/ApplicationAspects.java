package com.jdc.demo.utils;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import com.jdc.demo.dto.Member;

@Component
public class ApplicationAspects {

	public void afterReturningInsert(int value, Member input) {
		System.out.println("============================");
		System.out.println(input);
		System.out.println("After Returning Value is %d".formatted(value));
	}
	
	public void afterThrowingInsert(JoinPoint joinPoint, Member member, RuntimeException ex) {
		System.out.println("============================");
		System.out.println(member);
		System.out.println("After Throwing %s".formatted(ex.getClass()));
		System.out.println(ex.getMessage());
	}
}
