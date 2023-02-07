package com.jdc.morning.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.morning.entity.Course;
import com.jdc.morning.repo.CourseRepo;

@RestController
@RequestMapping("course")
public class CourseController {

	@Autowired
	private CourseRepo repo;
	
	@GetMapping
	List<Course> findAll() {
		return repo.findAll();
	}
	
	// /course/{id}
	@GetMapping("{id}")
	Course findById(@PathVariable int id) {
		return repo.findById(id).orElseThrow();
	}
}
