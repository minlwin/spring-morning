package com.jdc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jdc.morning.factory.ServiceFactory;
import com.jdc.morning.service.Service;

@Configuration
public class ServicesConfig {
	
	private ServiceFactory messageFactory;
	
	public ServicesConfig() {
		messageFactory = new ServiceFactory();
		messageFactory.setType("Message");
	}
	
	@Bean(name = {
			"messageServiceOne",
			"otherService",
			"secondaryService"
	})
	Service messageServiceOne() {
		return messageFactory.generate();
	}
}
