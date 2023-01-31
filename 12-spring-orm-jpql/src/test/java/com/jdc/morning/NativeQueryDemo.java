package com.jdc.morning;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.morning.dto.CourseIdWithName;
import com.jdc.morning.entity.Course;
import com.jdc.morning.utils.TestUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
public class NativeQueryDemo {
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Disabled
	void entityResultDemo() {
		
		var query = em.createNamedQuery("Course.nativeFindByLevel", Course.class);
		query.setParameter("level", 1);
		
		var result = query.getResultList();
		
		TestUtils.show(result);
	}
	
	@Test
	void projectionDemo() {
		var query = em.createNamedQuery("Course.native.findByLevelForList", CourseIdWithName.class);
		query.setParameter("level", 1);
		
		var result = query.getResultList();
		
		TestUtils.show(result);
	}
	
}
