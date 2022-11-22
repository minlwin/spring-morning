package com.jdc.morning;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyFirstBeanTest {

	@Test
	void test_hello() {
		
		// Create IoC Container
		var container = new ClassPathXmlApplicationContext();
		// Set Configuration
		container.setConfigLocation("/hello-spring.xml");
		// Refresh Container
		container.refresh();
		
		// Active Container
		// Get Beans
		var bean = container.getBean(MyFirstBean.class);
		var result = bean.sayHello();
		
		assertEquals("Hello Spring Framework", result);
		
		// Close Container
		container.close();
		
	}
	
	@Test
	void test_file_system_refreashable_context() {
		
		try(var container = new FileSystemXmlApplicationContext("file:/Users/minlwin/Desktop/hello-spring.xml")) {
			
			assertDoesNotThrow(() -> container.refresh());
			
			var bean = container.getBean(MyFirstBean.class);
			var result = bean.sayHello();
			
			assertEquals("Hello Spring Framework", result);			
		}
	}
	
	@Test
	void test_generic_xml_context_multiple_refresh_error() {
		
		try(var container = new GenericXmlApplicationContext("classpath:/hello-spring.xml")) {
			
			assertThrows(IllegalStateException.class, () -> container.refresh());
		}
	}

	@Test
	void test_generic_xml_context() {
		
		try(var container = new GenericXmlApplicationContext("classpath:/hello-spring.xml")) {
			var bean = container.getBean(MyFirstBean.class);
			var result = bean.sayHello();
			
			assertEquals("Hello Spring Framework", result);			
		}
	}

	@Test
	void test_generic_xml_context_file_system() {
		
		try(var container = new GenericXmlApplicationContext("file:/Users/minlwin/Desktop/hello-spring.xml")) {
			var bean = container.getBean(MyFirstBean.class);
			var result = bean.sayHello();
			
			assertEquals("Hello Spring Framework", result);			
		}
	}
	
	@Test
	void test_class_path_xml_context() {
		
		try(var container = new ClassPathXmlApplicationContext("/hello-spring.xml")) {
			var bean = container.getBean(MyFirstBean.class);
			var result = bean.sayHello();
			
			assertEquals("Hello Spring Framework", result);			
		}
	}
	
	
}
