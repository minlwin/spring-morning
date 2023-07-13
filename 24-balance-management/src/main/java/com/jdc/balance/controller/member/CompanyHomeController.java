package com.jdc.balance.controller.member;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.jdc.balance.model.data.form.PasswordForm;
import com.jdc.balance.model.data.form.ProfileForm;

public class CompanyHomeController {

	public CompanyHomeController() {
	}

	public String index(ModelMap model) {
		// TODO implement here
		return "";
	}

	public String editProfile() {
		// TODO implement here
		return "";
	}

	public String saveProfile(ProfileForm form, BindingResult result) {
		// TODO implement here
		return "";
	}

	public String changePassword(PasswordForm form, BindingResult result) {
		// TODO implement here
		return "";
	}

	public PasswordForm passwordForm() {
		// TODO implement here
		return null;
	}

	public ProfileForm profileForm() {
		// TODO implement here
		return null;
	}

}