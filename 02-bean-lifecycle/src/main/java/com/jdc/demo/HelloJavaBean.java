package com.jdc.demo;

import org.springframework.beans.factory.InitializingBean;

import jakarta.annotation.PostConstruct;

public class HelloJavaBean implements InitializingBean{

	public void sayHello() {
		System.out.println("Hello Java Base Config");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("After Properties Set");
	}
	
	public void init() {
		System.out.println("Initialization Method");
	}
	
	@PostConstruct
	private void postConstruct() {
		System.out.println("Post Construct");
	}
}
