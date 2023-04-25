package com.jdc.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("course")
public class CourseController {

	@GetMapping
	String search(@RequestParam Optional<String> name) {
		return "course-list";
	}
}
