package com.jdc.morning;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.morning.entity.Course;
import com.jdc.morning.utils.TestUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
public class NamedStoreProcedureQueryDemo {

	@PersistenceContext
	private EntityManager em;
	
	@Test
	@SuppressWarnings("unchecked")
	void demo() {
		
		var query = em.createNamedStoredProcedureQuery("Course.store.findByLevel");
		query.setParameter("level_in", 0);
		var result = (List<Course>)query.getResultList();
		
		TestUtils.show(result);
	}
}
