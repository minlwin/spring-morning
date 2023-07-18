package com.jdc.balance.controller.anonymous;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("public/home")
public class PublicHomeController {

	@GetMapping
	public String index() {
		return "views/anonymous/home";
	}

}