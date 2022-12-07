package com.jdc.demo.dao.dto;

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
