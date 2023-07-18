package com.jdc.balance.controller.anonymous;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.balance.model.data.form.SignUpForm;

@Controller
@RequestMapping("public/signup")
public class SignUpController {

	@GetMapping
	public String index() {
		// TODO implement here
		return "views/anonymous/signup";
	}

	@PostMapping
	public String signUp(
			@ModelAttribute("form") @Validated SignUpForm form, BindingResult result) {
		// TODO implement here
		return "";
	}

	@ModelAttribute("form")
	public SignUpForm form() {
		// TODO implement here
		return null;
	}

}