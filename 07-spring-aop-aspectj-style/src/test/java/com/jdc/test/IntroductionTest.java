package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.model.service.CourseService;
import com.jdc.demo.model.utils.intro.Loggable;

@SpringJUnitConfig(locations = "classpath:/application.xml")
public class IntroductionTest {

	@Autowired
	private CourseService service;
	
	@Test
	void test() {
		if(service instanceof Loggable loggable) {
			loggable.log();
		}
	}
}
