package com.jdc.balance.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee/project")
public class ProjectHomeController {

	@GetMapping("{project}")
	public String load(@PathVariable int project, ModelMap model) {
		// TODO implement here
		return "views/project/home";
	}

}
