package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.jdc.registration.model.DataSourceManager;
import com.jdc.registration.model.dao.CourseDao;
import com.jdc.registration.model.dto.Course;
import com.jdc.registration.model.dto.Course.Level;

public class CourseDaoTest {

	private CourseDao dao;

	@BeforeEach
	void intDao() {
		dao = new CourseDao(DataSourceManager.getDataSource());
	}

	@ParameterizedTest
	@CsvFileSource(delimiter = '\t', resources = "/course-insert.tsv")
	void test_save_insert(int id, String name, Level level, int duration, int fees, String description,
			boolean deleted) {
		// Prepare Data
		var course = new Course(name, level, duration, fees, description, deleted);

		// Execute Target Method
		var result = dao.save(course);

		// Check Result
		assertEquals(id, result);
	}
}
