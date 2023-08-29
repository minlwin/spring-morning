package com.jdc.balance.controller.member;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.balance.model.data.form.EmployeeForm;

@Controller
@RequestMapping("manager/employee")
public class CompanyEmployeeController {

	@GetMapping
	public String index(ModelMap model) {
		// TODO implement here
		return "views/member/employees";
	}

	@GetMapping("edit")
	public String edit(@RequestParam Optional<Integer> id) {
		// TODO implement here
		return "views/member/employees-edit";
	}

	@PostMapping("edit")
	public String save(@ModelAttribute("form") EmployeeForm form) {
		// TODO implement here
		return "redirect:/manager/employee";
	}

	@ModelAttribute("form")
	public EmployeeForm form(@RequestParam Optional<Integer> id) {
		// TODO implement here
		return null;
	}

}