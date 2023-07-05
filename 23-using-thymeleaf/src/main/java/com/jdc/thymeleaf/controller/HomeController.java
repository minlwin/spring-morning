package com.jdc.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.thymeleaf.service.DivisionService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private DivisionService service;

	@GetMapping
	String index(ModelMap model) {
		model.put("message", "<h3>Hello Thymeleaf Text Output</h3>");
		
		return "home";
	}
	
	@GetMapping("iteration")
	String iteration(ModelMap model) {
		model.put("list", service.findAll());
		return "iteration";
	}
}
