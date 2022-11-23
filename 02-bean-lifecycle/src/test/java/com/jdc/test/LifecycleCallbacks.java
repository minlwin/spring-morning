package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.demo.HelloXmlBean;

public class LifecycleCallbacks {

	@Test
	void test() {
		
		try(var context = new GenericXmlApplicationContext("classpath:/application.xml")) {
			var bean = context.getBean(HelloXmlBean.class);
			bean.sayHello();
		}
		
	}
}
