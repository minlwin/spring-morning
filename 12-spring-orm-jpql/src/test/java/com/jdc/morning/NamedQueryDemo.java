package com.jdc.morning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.morning.dto.CourseIdWithName;
import com.jdc.morning.entity.Course.Level;
import com.jdc.morning.utils.TestUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
public class NamedQueryDemo {

	@PersistenceContext
	private EntityManager em;
	
	@Test
	void usingNamedQuery() {
		
		var query = em.createNamedQuery("Course.searchForList", CourseIdWithName.class);
		query.setParameter("level", Level.Advance);
		
		var result = query.getResultList();
		
		TestUtils.show(result);
	}
}
