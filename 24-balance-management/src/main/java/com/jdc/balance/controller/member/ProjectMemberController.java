package com.jdc.balance.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.balance.model.data.form.ProjectMemberForm;

@Controller
@RequestMapping("manager/projects/members")
public class ProjectMemberController {

	@GetMapping("{project}")
	public String load(@PathVariable int project, ModelMap model) {
		// TODO implement here
		return "views/project/member-settings";
	}

	@PostMapping("{project}")
	public String save(
			@PathVariable int project, 
			@ModelAttribute("form") ProjectMemberForm form, BindingResult result) {

		return "redirect:/manager/projects/members/%d".formatted(project);
	}

	@ModelAttribute("form") 
	public ProjectMemberForm form(@PathVariable int project) {
		// TODO implement here
		return new ProjectMemberForm();
	}

}