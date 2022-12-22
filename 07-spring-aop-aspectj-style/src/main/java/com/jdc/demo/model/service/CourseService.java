package com.jdc.demo.model.service;

import java.util.List;

import com.jdc.demo.model.dto.Course;

public interface CourseService {

	int save(Course c);
	Course findById(int id);
	List<Course> findAll();
}
