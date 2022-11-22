package com.jdc.morning;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.morning.service.Service;

@SpringJUnitConfig(locations = "classpath:/service-config.xml")
public class BeanCreationDemo {

	@Autowired
	private Service service1;
	
	@Autowired
	private Service messageService1;
	
	@Autowired
	private Service messageService2;
	
	
	@Test
	void testServiceOne() {
		service1.execute();
		messageService1.execute();
		messageService2.execute();
	}
}
