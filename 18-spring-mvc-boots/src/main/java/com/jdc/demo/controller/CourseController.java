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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	/**
	 * url /course/
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("{id}")
	String showDetails(@PathVariable int id, ModelMap model) {
		model.put("dto", service.findById(id));
		return "course-details";
	}
	
	@PostMapping
	String save(@Validated @ModelAttribute("dto") Course dto, BindingResult result, RedirectAttributes model) {
		
		if(result.hasErrors()) {
			return "course-edit";
		}
		
		dto = service.save(dto);
		model.addFlashAttribute("message", "Course has been saved successfully!");
		
		return "redirect:/course/%d".formatted(dto.getId());
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
