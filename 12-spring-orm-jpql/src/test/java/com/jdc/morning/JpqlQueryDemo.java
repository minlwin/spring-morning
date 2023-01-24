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
class JpqlQueryDemo {
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
	void projection() {
		var query = em.createQuery(
				"""
				select new com.jdc.morning.dto.CourseIdWithName(c.id, c.name, c.level) 
				from Course c where c.level = ?1""", 
				CourseIdWithName.class);
		
		query.setParameter(1, Level.Basic);
		
		var result = query.getResultList();
		
		TestUtils.show(result);
	}
	
	@Test
	@Disabled
	void findName() {
		
		// select name from course
		var query = em.createQuery(
				"select c.name from Course c", String.class);
		
		var result = query.getResultList();
		
		TestUtils.show(result);
	}
	

	@Test
	@Disabled
	void findAll() {
		// select * from course
		var jpql = "select c from Course c";
		
		var query = em.createQuery(jpql, Course.class);
		
		var result = query.getResultList();
		
		TestUtils.show(result);
	}

}
