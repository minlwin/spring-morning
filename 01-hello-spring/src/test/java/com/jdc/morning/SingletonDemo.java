package com.jdc.morning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SingletonDemo {

	@Test
	void test() {
		
		
		try(var context = new GenericXmlApplicationContext()) {
			
			context.load("classpath:/scope-config.xml");
			context.refresh();
			
			var bean1 = context.getBean(MyFirstBean.class);
			var bean2 = context.getBean(MyFirstBean.class);
			
			assertEquals(bean1, bean2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
