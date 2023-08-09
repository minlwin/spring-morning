package com.jdc.balance.controller.member;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.balance.model.data.form.LedgerForm;

@Controller
@RequestMapping("manager/ledger")
public class LedgerController {

	
	@GetMapping
	public String index(ModelMap model) {
		return "views/member/ledgers";
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