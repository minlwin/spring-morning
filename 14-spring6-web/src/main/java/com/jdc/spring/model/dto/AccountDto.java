package com.jdc.spring.model.dto;

import com.jdc.spring.model.entity.Account.Role;

public interface AccountDto {

	Integer getId();
	String getName();
	String getEmail();
	Role getRole();
}
