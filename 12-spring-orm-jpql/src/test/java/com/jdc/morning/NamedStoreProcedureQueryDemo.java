package com.jdc.morning;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.morning.entity.Course;
import com.jdc.morning.entity.Course.Level;
import com.jdc.morning.utils.TestUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
@SuppressWarnings("unchecked")
public class NamedStoreProcedureQueryDemo {

	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Disabled
	void nameStoreProcedureQuery() {
		
		var query = em.createNamedStoredProcedureQuery("Course.store.findByLevel");
		query.setParameter("level_in", Level.Basic.ordinal());
		
		var result = (List<Course>)query.getResultList();
		
		TestUtils.show(result);
	}
	
	@Test
	void storeProcedureQueryInRuntime() {
		
		var storeProcedure = em.createStoredProcedureQuery("find_by_level", Course.class);
		storeProcedure.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
		
		storeProcedure.setParameter(1, Level.Basic.ordinal());
		
		var result = storeProcedure.getResultList();
		
		TestUtils.show(result);
		
	}
}
