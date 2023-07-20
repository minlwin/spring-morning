package com.jdc.balance.model.data.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignUpForm {

	@NotBlank(message = "Please enter your name.")
	private String name;
	@NotBlank(message = "Please enter your email.")
	private String email;
	@NotBlank(message = "Please enter password.")
	private String password;

}