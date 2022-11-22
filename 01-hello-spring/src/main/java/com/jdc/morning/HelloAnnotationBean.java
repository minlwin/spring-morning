package com.jdc.morning;

import org.springframework.stereotype.Component;

@Component
public class HelloAnnotationBean {

	public String message() {
		return "Hello Annotation Base Configuration.";
	}
}
