package com.jdc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	private List<String> demoMessages;

	@GetMapping
	String index(ModelMap model) {
		model.put("message", "Hello Model And View");
		return "home";
	}
	
	@PostMapping
	String createMessage(@RequestParam String message) {
		// 
		
		return "redirect:/home";
	}
	
	@GetMapping
	@ResponseBody
	List<String> getAllMessages() {
		return demoMessages;
	}
}
