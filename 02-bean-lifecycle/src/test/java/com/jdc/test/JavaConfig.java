package com.jdc.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jdc.demo.HelloJavaBean;

@Configuration
public class JavaConfig {

	@Bean(initMethod = "init")
	HelloJavaBean helloJavaBean() {
		return new HelloJavaBean();
	}
}
