package com.jdc.demo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class HelloXmlBean implements InitializingBean, DisposableBean{

	public void sayHello() {
		System.out.println("Hello Bean");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("After Properties Set");
	}
	
	public void initBean() {
		System.out.println("Init Bean Method");
	}
	
	@PostConstruct
	void postConstruct() {
		System.out.println("Post Construct Method");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy method by disposable bean");
	}
	
	public void destroyBean() {
		System.out.println("Destroy Method");
	}
	
	@PreDestroy
	void preDestroy() {
		System.out.println("Pre Destroy");
	}
	
}
