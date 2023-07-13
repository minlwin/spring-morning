package com.jdc.balance.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/home")
public class AdminHomeController {

	@GetMapping
	public String index(ModelMap model) {
		// TODO implement here
		return "";
	}

}