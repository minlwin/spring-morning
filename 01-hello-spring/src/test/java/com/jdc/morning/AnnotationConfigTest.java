package com.jdc.morning;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.config.AppConfig;

public class AnnotationConfigTest {
	
	@Test
	void test_java_base_config() {
		
		try (var container = new AnnotationConfigApplicationContext(AppConfig.class)) {
			assertNotNull(container.getBean(StringBuilder.class));
		} 
	}

	@Test
	void test_annotation_by_class() {
		
		try(var container = new AnnotationConfigApplicationContext(HelloAnnotationBean.class)) {
			var bean = container.getBean(HelloAnnotationBean.class);
			assertNotNull(bean);
			var message = bean.message();
			
			assertEquals("Hello Annotation Base Configuration.", message);
		}
	}
	
	@Test
	void test_annotation_by_scan() {
		
		try(var container = new AnnotationConfigApplicationContext("com.jdc.morning")) {
			var bean = container.getBean(HelloAnnotationBean.class);
			assertNotNull(bean);
			var message = bean.message();
			
			assertEquals("Hello Annotation Base Configuration.", message);
		}
	}
	
}
