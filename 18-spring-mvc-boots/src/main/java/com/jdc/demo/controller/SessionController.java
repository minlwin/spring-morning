package com.jdc.demo.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
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

import com.jdc.demo.model.entity.Course.Level;
import com.jdc.demo.model.entity.Session;
import com.jdc.demo.model.service.CourseService;
import com.jdc.demo.model.service.SessionService;

@Controller
@RequestMapping("session")
public class SessionController {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private SessionService sessionService;

	@GetMapping
	String search(
			@RequestParam Optional<Level> level,
			@RequestParam Optional<String> course,
			@RequestParam Optional<LocalDate> fromDate,
			@RequestParam Optional<LocalDate> toDate,
			ModelMap model) {
		
		model.put("levels", List.of(Level.values()));
		var result = sessionService.search(level, course, fromDate, toDate);
		model.put("list", result);
		
		return "session-list";
	}
	
	@GetMapping("{id}")
	String showDetails(@PathVariable int id, ModelMap model) {
		var dto = sessionService.findById(id);
		model.put("dto", dto);
		return "session-details";
	}
	
	@GetMapping("edit")
	String edit(ModelMap model) {
		var courses = courseService.search(Optional.empty());
		model.put("courses", courses);
		
		var days = DayOfWeek.values();
		model.put("days", days);
		
		return "session-edit";
	}
	
	@PostMapping
	String save(@Validated @ModelAttribute("dto") Session dto, BindingResult result, RedirectAttributes redirect, ModelMap model) {
		
		if(result.hasErrors()) {
			var courses = courseService.search(Optional.empty());
			model.put("courses", courses);
			var days = DayOfWeek.values();
			model.put("days", days);
			return "session-edit";
		}
		
		var isNewEntity = dto.getId() == 0;
		
		dto = sessionService.save(dto);
		
		redirect.addFlashAttribute("message", 
				"Session has been %s successfully.".formatted(isNewEntity ? "Created" : "Updated"));
		
		return "redirect:/session/%d".formatted(dto.getId());
	}
	
	@ModelAttribute("dto")
	Session getEditDto(@RequestParam Optional<Integer> id) {
		return id.filter(a -> a > 0).isEmpty() ? new Session() : sessionService.findById(id.get());
	}
}
