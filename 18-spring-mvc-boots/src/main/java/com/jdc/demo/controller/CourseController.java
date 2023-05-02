package com.jdc.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.demo.model.entity.Course;
import com.jdc.demo.model.entity.Course.Level;
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
	String edit() {
		
		return "course-edit";
	}
	
	@PostMapping
	String save(@Validated @ModelAttribute("dto") Course dto, BindingResult result) {
		
		if(result.hasErrors()) {
			return "course-edit";
		}
		
		service.save(dto);
		
		return "redirect:/course";
	}
	
	@ModelAttribute("dto")
	public Course getEditDto(@RequestParam(required = false, defaultValue = "0") int id) {
		return id > 0 ? service.findById(id) : new Course();
	}
	
	@ModelAttribute("levels")
	public List<Level> getLevels() {
		return List.of(Level.values());
	}
}
