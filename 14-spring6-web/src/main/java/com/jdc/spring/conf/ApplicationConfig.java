package com.jdc.spring.conf;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
@ComponentScan(basePackages = "com.jdc.spring.controller")
public class ApplicationConfig {

	@Bean
	RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
		var adapter = new RequestMappingHandlerAdapter();
		adapter.setMessageConverters(
			List.of(new MappingJackson2HttpMessageConverter())	
		);
		return adapter;
	}
}
