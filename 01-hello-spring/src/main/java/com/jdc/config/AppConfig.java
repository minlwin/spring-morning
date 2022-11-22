package com.jdc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.jdc.morning")
public class AppConfig {

	@Bean
	StringBuilder stringBuilder() {
		return new StringBuilder();
	}
	
}
