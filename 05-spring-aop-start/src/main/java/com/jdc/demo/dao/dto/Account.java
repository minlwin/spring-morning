package com.jdc.demo.dao.dto;

import com.jdc.demo.Dto;

@Dto
public record Account(
		int id,
		String name,
		String phone,
		String email
		) {

	public Account withId(int id) {
		return new Account(id, name, phone, email);
	}

}
