package com.jdc.spring.model.form;

import jakarta.validation.constraints.NotEmpty;

public record CategoryForm(
		@NotEmpty(message = "Please enter category name.")
		String name
		) {

}
