package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.model.service.CourseService;

@SpringJUnitConfig(locations = "classpath:/application.xml")
@Sql("classpath:/findByIdTest.sql")
public class FindByIdTest {

	@Autowired
	private CourseService service;
	
	@Test
	void find_by_id_success() {
		var result = service.findById(1);
		System.out.println(result);
	}
	
	@Test
	void find_by_id_error() {
		assertThrows(EmptyResultDataAccessException.class, () -> service.findById(2));
	}
}
