package com.jdc.morning.service;

public class Service {

	private int serviceNumber;
	private String type;
	
	public void setServiceNumber(int serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void execute() {
		System.out.println("%s Service %d is worked.".formatted(type, serviceNumber));
	}
}
