package com.jdc.morning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.morning.entity.Course.Level;
import com.jdc.morning.service.CourseService;

@SpringBootTest
public class CourseServiceTest {

	@Autowired
	private CourseService service;
	
	@ParameterizedTest
	@CsvSource({
		",,,,5",
		"Basic,,,,2",
		",Java,,,2",
		",,4,,2",
		",,,3,3",
	})
	void test_search(Level level, String name, Integer monthFrom, Integer monthTo, int size) {
		var result = service.search(level, name, monthFrom, monthTo);
		assertEquals(size, result.size());
	}
	
	@ParameterizedTest
	@CsvSource({
		",,,,5",
		"Basic,,,,2",
		",Java,,,2",
		",,4,,2",
		",,,3,3",
	})
	void test_search_criteria(Level level, String name, Integer monthFrom, Integer monthTo, int size) {
		var result = service.searchWithCriteria(level, name, monthFrom, monthTo);
		assertEquals(size, result.size());
	}
	
}
