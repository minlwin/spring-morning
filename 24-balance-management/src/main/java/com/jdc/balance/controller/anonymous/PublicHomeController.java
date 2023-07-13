package com.jdc.balance.controller.anonymous;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("public/home")
public class PublicHomeController {

	public String index() {
		return "";
	}

}