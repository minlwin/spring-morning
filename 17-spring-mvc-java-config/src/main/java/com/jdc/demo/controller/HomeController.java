package com.jdc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	private List<String> demoMessages;

	@GetMapping
	String index(Model model) {
		model.addAttribute("demo", demoMessages);
		model.addAttribute("message", "Hello Srping MVC");
		return "home";
	}
}
