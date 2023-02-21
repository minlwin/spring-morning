package com.jdc.spring.model.form;

public record ProductForm(
		String name,
		int categoryId,
		String photo,
		int price
		) {

}
