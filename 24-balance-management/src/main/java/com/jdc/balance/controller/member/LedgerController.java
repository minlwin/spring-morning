package com.jdc.balance.controller.member;

import java.util.Optional;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.jdc.balance.model.data.form.LedgerForm;

public class LedgerController {

	public LedgerController() {
	}

	public String index(ModelMap model) {
		// TODO implement here
		return "";
	}

	public String edit(int company, Optional<Integer> id) {
		// TODO implement here
		return "";
	}

	public String save(LedgerForm form, BindingResult result) {
		// TODO implement here
		return "";
	}

	public LedgerForm form(Optional<Integer> id) {
		// TODO implement here
		return null;
	}

}