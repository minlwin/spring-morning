package com.jdc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {

	@GetMapping
	public String index(Model model) {
		model.addAttribute("message", "Hello from Spring Controller");
		return "home";
	}
}
