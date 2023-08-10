package com.jdc.balance.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.balance.model.data.form.LedgerForm;

@Controller
@RequestMapping("manager/ledger")
public class LedgerController {

	
	@GetMapping
	public String index(ModelMap model) {
		return "views/member/ledgers";
	}
	
	@PostMapping
	public String save(@Validated LedgerForm form, BindingResult result) {
		// TODO implement here
		return "redirect:/manager/ledger";
	}


}