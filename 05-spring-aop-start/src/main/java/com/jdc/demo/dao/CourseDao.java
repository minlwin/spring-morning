package com.jdc.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.jdc.demo.BaseDao;
import com.jdc.demo.dao.dto.Course;

@Repository
@Qualifier("course")
public class CourseDao implements BaseDao<Course>{

	@Override
	public int create(Course data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(int id, Course data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Course findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
