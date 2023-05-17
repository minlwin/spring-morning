package com.jdc.demo.model.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.model.entity.Course.Level;
import com.jdc.demo.model.repo.SessionRepo;

import jakarta.persistence.EntityNotFoundException;

import com.jdc.demo.model.entity.Session;

@Service
@Transactional(readOnly = true)
public class SessionService {
	
	@Autowired
	private SessionRepo repo;

	public List<Session> search(Optional<Level> level, Optional<String> course, Optional<LocalDate> fromDate,
			Optional<LocalDate> toDate) {
		return repo.findAll(withLevel(level)
				.and(withCourseName(course))
				.and(withDateFrom(fromDate).and(withDateTo(toDate))));
	}

	public Session findById(int id) {
		return repo.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	@Transactional
	public Session save(Session dto) {
		return repo.save(dto);
	}
	
	private Specification<Session> withLevel(Optional<Level> param) {
		return param.isEmpty() ? Specification.where(null) : 
			(root, query, cb) -> cb.equal(root.get("course").get("level"), param.get());
	}

	private Specification<Session> withCourseName(Optional<String> param) {
		return param.isEmpty() ? Specification.where(null) : 
			(root, query, cb) -> cb.like(root.get("course").get("name"), param.get().concat("%"));
	}
	
	private Specification<Session> withDateFrom(Optional<LocalDate> param) {
		return param.isEmpty() ? Specification.where(null) : 
			(root, query, cb) -> cb.greaterThanOrEqualTo(root.get("startDate"), param.get());
	}
	
	private Specification<Session> withDateTo(Optional<LocalDate> param) {
		return param.isEmpty() ? Specification.where(null) : 
			(root, query, cb) -> cb.lessThanOrEqualTo(root.get("startDate"), param.get());
	}
}
