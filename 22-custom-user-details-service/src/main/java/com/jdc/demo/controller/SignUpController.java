package com.jdc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.demo.controller.form.SignUpForm;
import com.jdc.demo.service.security.SignUpService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("signup")
public class SignUpController {
	
	@Autowired
	private SignUpService service;
	
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private SecurityContextRepository securityContextRepository;
	
	@GetMapping
	String index() {
		return "signup";
	}
	
	@PostMapping
	String signUp(HttpServletRequest req, HttpServletResponse resp ,@ModelAttribute @Validated SignUpForm form, BindingResult result) {
		
		if(result.hasErrors()) {
			return "signup";
		}
		
		service.signUp(form);
		
		var token = authManager.authenticate(new UsernamePasswordAuthenticationToken(form.getEmail(), form.getPassword()));
		var securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(token);
		
		securityContextRepository.saveContext(securityContext, req, resp);
		
		return "redirect:/customer";
	}
	
	@ModelAttribute("form")
	SignUpForm form() {
		return new SignUpForm();
	}
}
