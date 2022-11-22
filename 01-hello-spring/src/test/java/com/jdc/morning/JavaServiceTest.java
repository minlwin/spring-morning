package com.jdc.morning;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.config.ServicesConfig;
import com.jdc.morning.service.Service;

@SpringJUnitConfig(classes = ServicesConfig.class)
public class JavaServiceTest {
	
	@Autowired
	private Service service;
	
	@Test
	void test() {
		service.execute();
	}
}
