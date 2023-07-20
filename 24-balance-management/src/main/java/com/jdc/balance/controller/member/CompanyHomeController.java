package com.jdc.balance.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.balance.model.data.form.PasswordForm;
import com.jdc.balance.model.data.form.ProfileForm;

@Controller
@RequestMapping("member/home")
public class CompanyHomeController {

	@GetMapping
	public String index(ModelMap model) {
		return "views/member/home";
	}

	@GetMapping("profile")
	public String editProfile() {
		// TODO implement here
		return "";
	}

	@PostMapping("profile")
	public String saveProfile(ProfileForm form, BindingResult result) {
		// TODO implement here
		return "";
	}

	@PostMapping("password")
	public String changePassword(PasswordForm form, BindingResult result) {
		// TODO implement here
		return "";
	}

	public PasswordForm passwordForm() {
		return new PasswordForm();
	}

	public ProfileForm profileForm() {
		return new ProfileForm();
	}

}