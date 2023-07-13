package com.jdc.balance.controller.member;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("employee/reports")
public class BalanceReportController {

	@GetMapping("{project}")
	public String search(
			@PathVariable int project, 
			@RequestParam Optional<LocalDate> from, 
			@RequestParam Optional<LocalDate> to,
			ModelMap model) {
		// TODO implement here
		return "";
	}

}