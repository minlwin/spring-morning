package com.jdc.demo;

import org.springframework.stereotype.Component;

@Component
public class BeanC {

	private BeanA bean;

	public BeanC(BeanA bean) {
		super();
		this.bean = bean;
	}
}
