package com.jdc.demo.dao;

import java.util.List;

import com.jdc.demo.dto.Course;

public interface CourseDao {

	List<Course> getAll();

	int insert(Course course);

	int update(Course course);

	void deleteById(int id);

	long findCountByLevel(int level);

	Course findById(int id);

	List<Course> search(Integer level, String name, Boolean deleted);

}