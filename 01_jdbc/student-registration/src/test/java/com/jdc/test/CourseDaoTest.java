package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.registration.model.DataSourceManager;
import com.jdc.registration.model.dao.CourseDao;
import com.jdc.registration.model.dto.Course;
import com.jdc.registration.model.dto.Course.Level;
import com.jdc.test.utils.DbUtils;

public class CourseDaoTest {

	private CourseDao dao;

	@BeforeEach
	void intDao() {
		dao = new CourseDao(DataSourceManager.getDataSource());
		
		DbUtils.truncate("course", "classes", "teacher");
		
		DbUtils.execute(
				"insert into course values (1,'Java Basic', 'Entry',90,300000, 'Foundation for Java Programming', false);",
				"insert into course values (2,'Spring Framework', 'Intermediate',180,500000, 'Framework course for Java', false);",
				"insert into course values (3,'Angular Framework', 'Advance',120,300000, 'Front End Framework Course', false);",
				"insert into course values (4,'Flutter', 'Intermediate',180,300000, 'Mobile Development Course', true);	"
				);
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
	
	@ParameterizedTest
	@CsvFileSource(delimiter = '\t', resources = "/course-find-by-id.txt")
	void test_find_by_id(int id, String name, Level level, int duration, int fees, String description, boolean deleted) {
		
		var result = dao.findById(id);
		
		assertNotNull(result);
		assertEquals(id, result.getId());
		assertEquals(name, result.getName());
		assertEquals(level, result.getLevel());
		assertEquals(duration, result.getDuration());
		assertEquals(fees, result.getFees());
		assertEquals(description, result.getDescription());
		assertEquals(deleted, result.isDeleted());
		
	}
	
	@ParameterizedTest
	@ValueSource(ints = {0, 5, 6})
	void test_find_by_id_not_found(int id) {
		
		var result = dao.findById(id);
		
		assertNull(result);
	}
}
