package com.jdc.registration.model.dao;

import java.util.List;

import javax.sql.DataSource;

import com.jdc.registration.model.dto.Course;
import com.jdc.registration.model.dto.Course.Level;

public class CourseDao {

	// Dependency
	private DataSource dataSource;

	public CourseDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int save(Course dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	public Course findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Course> search(Level level, String name) {
		// TODO Auto-generated method stub
		return null;
	}

}