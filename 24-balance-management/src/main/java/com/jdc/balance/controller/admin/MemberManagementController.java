package com.jdc.balance.controller.admin;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.balance.model.data.entity.consts.Role;
import com.jdc.balance.model.data.form.MemberStatusForm;
import com.jdc.balance.model.service.MemberService;

@Controller
@RequestMapping("admin/member")
public class MemberManagementController {
	
	@Autowired
	private MemberService service;

	@GetMapping
	public String search(ModelMap model, 
			@RequestParam Optional<Role> role, 
			@RequestParam Optional<String> name,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<LocalDate> from,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<LocalDate> to,
			@RequestParam(required = false, defaultValue = "0") int page, 
			@RequestParam(required = false, defaultValue = "10") int size) {
		
		model.put("result", service.search(role, name, from, to, page, size));
		
		return "views/admin/members";
	}

	@GetMapping("{email}")
	public String showDetails(@PathVariable String email, ModelMap model) {
		// TODO implement here
		return "views/admin/member-details";
	}

	@PostMapping("{email}")
	public String updateStatus(
			@ModelAttribute("form") @Validated MemberStatusForm form, BindingResult result) {
		// TODO implement here
		return "views/admin/member-details";
	}

	@ModelAttribute("form")
	public MemberStatusForm memberForm() {
		// TODO implement here
		return null;
	}

}