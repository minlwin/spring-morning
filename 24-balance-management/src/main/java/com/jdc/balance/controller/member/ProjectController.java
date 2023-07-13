package com.jdc.balance.controller.member;

import java.util.Optional;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.jdc.balance.model.data.form.ProjectForm;

public class ProjectController {

	public ProjectController() {
	}

	public String load(int project, ModelMap model) {
		// TODO implement here
		return "";
	}

	public String edit(int company, Optional<Integer> project) {
		// TODO implement here
		return "";
	}

	public String save(int company, ProjectForm form, BindingResult result) {
		// TODO implement here
		return "";
	}

	public ProjectForm form(int company, Optional<Integer> id) {
		// TODO implement here
		return null;
	}

}