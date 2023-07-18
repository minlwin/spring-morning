package com.jdc.balance.model.data.form;

import lombok.Data;

@Data
public class SignUpForm {

	private String name;
	private String email;
	private String password;
	private String phone;
	private String companyName;
	private String description;

}