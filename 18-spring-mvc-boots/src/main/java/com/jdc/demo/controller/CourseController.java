package com.jdc.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.demo.model.service.CourseService;

@Controller
@RequestMapping("course")
public class CourseController {
	
	@Autowired
	private CourseService service;

	@GetMapping
	String search(@RequestParam Optional<String> name, ModelMap model) {
		model.put("list", service.search(name));
		return "course-list";
	}
	
	/**
	 * url /course/edit
	 * @return
	 */
	@GetMapping("edit")
	String edit(@RequestParam(required = false, defaultValue = "0") int id, ModelMap model) {
		if(id > 0) {
			model.put("dto", service.findById(id));
		}
		return "course-edit";
	}
}
