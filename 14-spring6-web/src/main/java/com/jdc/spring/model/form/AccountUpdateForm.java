package com.jdc.spring.model.form;

import com.jdc.spring.model.entity.Account.Role;

public record AccountUpdateForm(
		String name,
		String email,
		Role role
		) {

}
