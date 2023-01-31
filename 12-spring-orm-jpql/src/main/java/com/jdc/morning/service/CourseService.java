package com.jdc.morning.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.morning.entity.Course;
import com.jdc.morning.entity.Course.Level;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class CourseService {

	@PersistenceContext
	private EntityManager em;
	
	public List<Course> search(Level level, String name, Integer monthFrom, Integer monthTo) {
		
		if(null != level) {
			
		}
		
		if(StringUtils.hasLength(name)) {
			
		}
		
		if(null != monthFrom) {
			
		}
		
		if(null != monthTo) {
			
		}
		
		return null;
	}
}
