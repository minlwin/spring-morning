package com.jdc.test.demo;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.dao.dto.Account;
import com.jdc.demo.service.RegistrationService;

@SpringJUnitConfig(locations = "classpath:/application.xml")
public class AopDemoTest {
	
	@Autowired
	private RegistrationService service;
	
	@Test
	void test() {
		service.register(new Account(0, "Maung Maung", "0971819191", "maung@gmail.com"), 
				1, LocalDate.now());
	}
}
