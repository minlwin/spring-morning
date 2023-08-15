package com.jdc.balance.controller.member;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.balance.model.data.form.ProjectForm;

@Controller
@RequestMapping("manager/projects/edit")
public class ProjectController {

	@GetMapping
	public String edit(
			@RequestParam Optional<Integer> project) {
		// TODO implement here
		return "views/project/edit-project";
	}

	@PostMapping
	public String save(
			@ModelAttribute("form") ProjectForm form, BindingResult result) {
		// TODO implement here
		return "redirect:/employee/project/1";
	}

	@ModelAttribute("form")
	public ProjectForm form(@RequestParam Optional<Integer> id) {
		// TODO implement here
		return new ProjectForm();
	}

}