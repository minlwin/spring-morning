package com.jdc.spring.model.form;

import com.jdc.spring.model.entity.Account;
import com.jdc.spring.model.entity.Account.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AccountForm(
		@NotEmpty(message = "Please enter account name.")
		String name,
		@NotEmpty(message = "Please enter email.")
		@Email(message = "Please enter email with correct format.")
		String email,
		@NotNull(message = "Please enter role.")
		Role role,
		@NotNull(message = "Please enter password.")
		String password
		) {
	
	public Account entity() {
		return new Account(name, email, password, role);
	}
}
