package com.jdc.shop;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ShopAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {
			ShopAppWebConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
