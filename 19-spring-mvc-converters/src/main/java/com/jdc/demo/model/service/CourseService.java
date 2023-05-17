package com.jdc.demo.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.model.entity.Course;
import com.jdc.demo.model.repo.CourseRepo;

@Service
@Transactional(readOnly = true)
public class CourseService {
	
	@Autowired
	private CourseRepo repo;

	public List<Course> search(Optional<String> name) {
		return repo.findAll(byName(name));
	}

	public Course findById(int id) {
		return repo.findById(id).orElseThrow();
	}
	
	// lower(c.name) like ?
	private Specification<Course> byName(Optional<String> name) {
		return name.isEmpty() ? Specification.where(null) : 
			(root, query, cb) -> cb.like(cb.lower(root.get("name")), name.get().toLowerCase().concat("%"));
	}

	@Transactional
	public Course save(Course dto) {
		return repo.save(dto);
	}

}
