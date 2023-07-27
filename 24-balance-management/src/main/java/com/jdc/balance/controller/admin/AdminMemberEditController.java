package com.jdc.balance.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.balance.model.data.form.AdminMemberForm;

@Controller
@RequestMapping("admin/member/edit")
public class AdminMemberEditController {

	@GetMapping
	public String edit() {
		// TODO implement here
		return "views/admin/member-edit";
	}

	@PostMapping
	public String save(
			@ModelAttribute("form") @Validated AdminMemberForm form, 
			BindingResult result) {
		// TODO implement here
		return "";
	}

	@ModelAttribute("form")
	public AdminMemberForm form() {
		// TODO implement here
		return null;
	}

}