package com.jdc.morning.factory;

import com.jdc.morning.service.Service;

public class ServiceFactory {

	private int counter;
	private String type;
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Service generate() {
		var service = new Service();
		service.setServiceNumber(++ counter);
		service.setType(type);
		return service;
	}
}
