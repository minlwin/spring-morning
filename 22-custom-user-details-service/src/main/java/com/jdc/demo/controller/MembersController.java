package com.jdc.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.demo.service.MemberService;
import com.jdc.demo.service.entity.Members;
import com.jdc.demo.service.entity.Members.Role;

@Controller
@RequestMapping("manager/member")
public class MembersController {
	
	@Autowired
	private MemberService service;

	@GetMapping
	String search(
			@RequestParam Optional<Role> role,
			@RequestParam Optional<String> keyword,
			ModelMap model
			) {
		model.put("list", service.search(role, keyword));
		return "member/list";
	}
	
	@GetMapping("edit")
	String edit() {
		return "member/edit";
	}
	
	@PostMapping("edit")
	String save(@Validated @ModelAttribute("form") Members form, BindingResult result) {
		
		if(result.hasErrors()) {
			return "member/edit";
		}
		
		service.save(form);
		
		return "redirect:/manager/member";
	}
	
	@ModelAttribute("form")
	Members form(@RequestParam(required = false) Integer id) {
		return null == id ? new Members() : service.findById(id);
	}
	
	@ModelAttribute("roles")
	Role [] roles() {
		return Role.values();
	}
}
