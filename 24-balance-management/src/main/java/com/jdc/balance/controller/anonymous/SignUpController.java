package com.jdc.balance.controller.anonymous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.balance.model.data.form.SignUpForm;
import com.jdc.balance.model.service.MemberService;

@Controller
@RequestMapping("public/signup")
public class SignUpController {
	
	@Autowired
	private MemberService service;

	@GetMapping
	public String index() {
		return "views/anonymous/signup";
	}

	@PostMapping
	public String signUp(
			@ModelAttribute("form") @Validated SignUpForm form, BindingResult result) {
		
		if(result.hasErrors()) {
			return "views/anonymous/signup";
		}
		
		service.signUp(form);
		
		return "redirect:/member/home";
	}

	@ModelAttribute("form")
	public SignUpForm form() {
		return new SignUpForm();
	}

}