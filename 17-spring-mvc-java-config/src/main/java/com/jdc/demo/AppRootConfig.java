package com.jdc.demo;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppRootConfig {

	@Bean
	List<String> demoMessages() {
		return List.of("Hello Spring", "Hello Java Config", "Changing Code");
	}
}
