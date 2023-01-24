package com.jdc.morning;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.morning.dto.CourseIdWithName;
import com.jdc.morning.entity.Course;
import com.jdc.morning.entity.Course.Level;
import com.jdc.morning.utils.TestUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
public class CriteriaQueryDemo {

	@PersistenceContext
	private EntityManager em;
	
	@Test
	void projection() {
		
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(CourseIdWithName.class);
		
		var root = cq.from(Course.class);
		cq.select(
			cb.construct(CourseIdWithName.class, 
					root.get("id"), root.get("name"), root.get("level")));
		
		// where c.level = Level.Basic
		cq.where(cb.equal(root.get("level"), Level.Basic));
		
		var result = em.createQuery(cq).getResultList();
		TestUtils.show(result);
	}
	
	
	@Test
	@Disabled
	void findName() {
		
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(String.class);
		
		var root = cq.from(Course.class);
		cq.select(root.get("name"));
		
		var query = em.createQuery(cq);
		var result = query.getResultList();
		
		TestUtils.show(result);
		
	}
	
	@Test
	@Disabled
	void findAll() {
		
		// select c from Course c
		// Create Criteria Query
		var builder = em.getCriteriaBuilder();
		
		// Represent main query 
		var criteriaQuery = builder.createQuery(Course.class);
		
		// From Clause
		var root = criteriaQuery.from(Course.class);
		
		// Select Clause
		criteriaQuery.select(root);
		
		var query = em.createQuery(criteriaQuery);
		
		var result = query.getResultList();
		
		TestUtils.show(result);
	}
}
