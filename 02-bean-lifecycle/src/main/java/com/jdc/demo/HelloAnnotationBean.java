package com.jdc.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class HelloAnnotationBean implements InitializingBean{

	public void sayHello() {
		System.out.println("Hello Annotation Bean");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("After Properties Set");
	}
	
	@PostConstruct
	void postConstruct() {
		System.out.println("Post Construct");
	}

}
