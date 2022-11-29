package com.jdc.demo;

import org.springframework.stereotype.Component;

@Component
public class BeanB {
	
	private BeanC beanC;

	public BeanB(BeanC beanC) {
		super();
		this.beanC = beanC;
	}

}
