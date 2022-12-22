package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.config.AppConfig;
import com.jdc.demo.model.dto.Course;
import com.jdc.demo.model.service.CourseService;

@SpringJUnitConfig(classes = AppConfig.class)
public class CourseServiceTest {

	@Autowired
	private CourseService service;
	
	@ParameterizedTest
	@CsvSource({
		"Java Basic,4,300000"
	})
	@Sql(statements = "truncate table course")
	void test_save(String name, int duration, int fees) {
		Course input = new Course(0, name, duration, fees);
		var result = service.save(input);
		assertEquals(1, result);
	}
	
	@ParameterizedTest
	@CsvSource({
		",4,300000"
	})
	@Sql(statements = "truncate table course")
	void test_save_exception(String name, int duration, int fees) {
		assertThrows(Throwable.class, () -> service.save(new Course(0, name, duration, fees)));
	}
	
}
