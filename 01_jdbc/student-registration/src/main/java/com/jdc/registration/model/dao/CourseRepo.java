package com.jdc.registration.model.dao;

import java.util.List;

import com.jdc.registration.model.dto.Course;
import com.jdc.registration.model.dto.Course.Level;

public interface CourseRepo {

	int save(Course dto);

	Course findById(int id);

	void delete(int id);

	List<Course> search(Level level, String name);

}