package com.jdc.balance.controller.member;

import java.util.Optional;

import org.springframework.ui.ModelMap;

import com.jdc.balance.model.data.form.EmployeeForm;

public class CompanyEmployeeController {

	public CompanyEmployeeController() {
	}

	public String index(ModelMap model) {
		// TODO implement here
		return "";
	}

	public String edit(int company, Optional<Integer> id) {
		// TODO implement here
		return "";
	}

	public String save(EmployeeForm form) {
		// TODO implement here
		return "";
	}

	public EmployeeForm form(Optional<Integer> id) {
		// TODO implement here
		return null;
	}

}