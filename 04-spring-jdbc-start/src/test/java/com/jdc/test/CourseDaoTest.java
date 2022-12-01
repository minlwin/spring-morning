package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.dao.CourseSpringDao;

@SpringJUnitConfig(locations = "classpath:/db-config.xml")
@Sql(scripts = "/course-data.sql")
public class CourseDaoTest {

	@Autowired
	private CourseSpringDao dao;
	
	@ParameterizedTest
	@CsvFileSource(resources = "/test_find_by_id.txt")
	void test_find_by_id(int id, String name, int level, int duration, int fees, String description, boolean deleted) {
		var result = dao.findById(id);
		
		assertNotNull(result);
		assertEquals(id, result.id());
		assertEquals(name, result.name());
		assertEquals(level, result.level());
		assertEquals(duration, result.duration());
		assertEquals(fees, result.fees());
		assertEquals(description, result.description());
		assertEquals(deleted, result.deleted());		
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,2",
		"2,2",
		"3,0"
	})
	void test_find_count_by_level(int level, long expected) {
		var result = dao.findCountByLevel(level);
		assertEquals(expected, result);
	}
	
	@ParameterizedTest
	@CsvSource({
		",,,4",
		"1,,,2",
		"2,,true,1",
		"2,spring,,1",
		"2,spring,true,0",
	})
	void test_search(Integer level, String name, Boolean deleted, int expectedCount) {
		var result = dao.search(level, name, deleted);
		assertEquals(expectedCount, result.size());
	}
}
