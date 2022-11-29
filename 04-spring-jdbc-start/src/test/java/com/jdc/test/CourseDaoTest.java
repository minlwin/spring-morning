package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.dao.CourseSpringDao;

@SpringJUnitConfig(locations = "classpath:/db-config.xml")
public class CourseDaoTest {

	@Autowired
	private CourseSpringDao dao;
	
	@Test
	void test() {
		var result = dao.getAll();
		
		for(var c : result) {
			System.out.println(c);
		}
	}
}
