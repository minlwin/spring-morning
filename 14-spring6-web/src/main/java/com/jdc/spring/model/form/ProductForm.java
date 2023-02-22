package com.jdc.spring.model.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ProductForm(
		@NotEmpty(message = "Please enter product name.")
		String name,
		@NotNull(message = "Please select category")
		Integer categoryId,
		String photo,
		int price
		) {

}
