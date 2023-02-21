package com.jdc.spring.model.dto;

public interface ProductDto {
	
	int getId();
	CategoryDto getCategory();
	String getName();
	String getPhoto();
	int getPrice();
}
