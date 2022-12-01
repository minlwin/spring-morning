package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.dao.CourseDao;
import com.jdc.demo.dto.Course;

@SpringJUnitConfig(locations = "classpath:/db-config.xml")
@Sql(scripts = "/course-data.sql")
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class CourseDaoTestForNamedParameter {

	@Autowired
	@Qualifier("usingNamedParameter")
	private CourseDao dao;
	
	@Order(1)
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
	
	@Order(2)
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
	
	@Order(3)
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
	
	@Order(4)
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void test_delete(int id) {
		dao.deleteById(id);
		var result = dao.findById(id);
		assertTrue(result.deleted());
	}
	
	@Order(5)
	@ParameterizedTest
	@CsvFileSource(resources = "/test_update.txt")
	void test_update(int id, String name, int level, int duration, int fees, String description, boolean deleted) {
		
		var updatedId = dao.update(new Course(id, name, level, duration, fees, description, deleted));
		
		var result = dao.findById(updatedId);
		
		assertNotNull(result);
		assertEquals(id, result.id());
		assertEquals(name, result.name());
		assertEquals(level, result.level());
		assertEquals(duration, result.duration());
		assertEquals(fees, result.fees());
		assertEquals(description, result.description());
		assertEquals(deleted, result.deleted());		
	}
	
	@Order(6)
	@ParameterizedTest
	@CsvFileSource(resources = "/test_insert.txt")
	void test_insert(int id, String name, int level, int duration, int fees, String description, boolean deleted) {
		var result = dao.insert(new Course(0, name, level, duration, fees, description, deleted));
		assertEquals(id, result);
	}
	
	@Order(7)
	@Test
	void test_get_all() {
		var result = dao.getAll();
		assertEquals(4, result.size());
	}
}
