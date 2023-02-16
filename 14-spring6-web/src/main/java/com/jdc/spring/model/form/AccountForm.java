package com.jdc.spring.model.form;

import com.jdc.spring.model.entity.Account;
import com.jdc.spring.model.entity.Account.Role;

public record AccountForm(
		String name,
		String email,
		Role role,
		String password
		) {
	
	public Account entity() {
		return new Account(name, email, password, role);
	}
}
