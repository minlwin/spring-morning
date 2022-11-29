package com.jdc.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:/application.xml")
public class CircularDependencyDemo {

	@Autowired
	private BeanA beanA;
	
	@Test
	void test() {
		
	}
}
