package com.jdc.demo.controller.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.jdc.demo.model.entity.Course;
import com.jdc.demo.model.repo.CourseRepo;

@Component
public class CourseConverter implements Converter<String, Course>{

	@Autowired
	private CourseRepo repo;
	
	@Override
	public Course convert(String id) {
		return StringUtils.hasLength(id) ? 
				repo.findById(Integer.parseInt(id)).orElse(null) : null;
	}

}
