package com.jdc.balance.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.balance.model.data.form.MemberStatusForm;

@Controller
@RequestMapping("admin/member")
public class MemberManagementController {

	@GetMapping
	public String search(ModelMap model) {
		// TODO implement here
		return "views/admin/members";
	}

	@GetMapping("{email}")
	public String showDetails(@PathVariable String email, ModelMap model) {
		// TODO implement here
		return "";
	}

	@PostMapping("status")
	public String updateStatus(
			@ModelAttribute("form") @Validated MemberStatusForm form, BindingResult result) {
		// TODO implement here
		return "";
	}

	@ModelAttribute("form")
	public MemberStatusForm memberForm() {
		// TODO implement here
		return null;
	}

}