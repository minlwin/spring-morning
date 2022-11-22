package com.jdc.morning.service;

import org.springframework.stereotype.Component;

@Component
public class AnnotationService {

	private int serviceNumber;
	private String type;

	public AnnotationService() {
		super();
		this.serviceNumber = 1;
		this.type = "Annotation";
	}

	public void execute() {
		System.out.println("%s service %d is worked.".formatted(type, serviceNumber));
	}
}
