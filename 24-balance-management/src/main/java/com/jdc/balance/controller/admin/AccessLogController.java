package com.jdc.balance.controller.admin;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("admin/access/logs")
public class AccessLogController {

	@GetMapping
	public String search(
			@RequestParam Optional<LocalDate> from, 
			@RequestParam Optional<LocalDate> to, 
			ModelMap model) {

		return "views/admin/access-logs";
	}

}