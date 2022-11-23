package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.demo.HelloJavaBean;

public class LifecycleJavaTest {

	@Test
	void test() {
		
		try(var context = new AnnotationConfigApplicationContext(JavaConfig.class)) {
			
			var bean = context.getBean(HelloJavaBean.class);
			bean.sayHello();
		}
	}
}
