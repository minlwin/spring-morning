package com.jdc.morning;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.morning.service.AnnotationService;

@SpringJUnitConfig(classes = {
		AnnotationService.class
})
public class AnnotationServiceTest {

	@Autowired
	private AnnotationService service;
	
	@Test
	void test() {
		service.execute();
	}
}
