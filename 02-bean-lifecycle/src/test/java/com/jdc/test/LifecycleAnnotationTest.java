package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.demo.HelloAnnotationBean;

public class LifecycleAnnotationTest {

	@Test
	void test() {
		
		try(var context = new AnnotationConfigApplicationContext(HelloAnnotationBean.class)) {
			var bean = context.getBean(HelloAnnotationBean.class);
			bean.sayHello();
		}
	}
}
