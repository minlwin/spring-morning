package com.jdc.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.registration.AppDataValidationException;
import com.jdc.registration.DataSourceManager;
import com.jdc.registration.model.CourseRepo;
import com.jdc.registration.model.dao.CourseDao;
import com.jdc.registration.model.dto.Course;
import com.jdc.registration.model.dto.Course.Level;
import com.jdc.test.utils.DbUtils;

@TestMethodOrder(OrderAnnotation.class)
public class CourseDaoTest {

	private CourseRepo dao;

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

	@Order(1)
	@ParameterizedTest
	@CsvFileSource(delimiter = '\t', resources = "/course/course-insert.txt")
	void test_save_insert(int id, String name, Level level, int duration, int fees, String description,
			boolean deleted) {
		// Prepare Data
		var course = new Course(name, level, duration, fees, description, deleted);

		// Execute Target Method
		var result = dao.save(course);

		// Check Result
		assertThat(result, is(id));
		
	}
	
	@Order(2)
	@Test
	void test_save_insert_with_null_data() {
		
		var exception = assertThrows(AppDataValidationException.class, () -> dao.save(null));
			
		assertThat(exception, allOf(
				notNullValue(),
				hasProperty("messages", hasSize(1))
		));
	}
	
	@Order(3)
	@ParameterizedTest
	@CsvFileSource(delimiter = '\t', resources = "/course/test_save_insert_name_duplication.txt")
	void test_save_insert_name_duplication(String name, Level level, int duration, int fees, String description,
			boolean deleted) {
		
		// Prepare Data
		var course = new Course(name, level, duration, fees, description, deleted);
		
		var exception = assertThrows(AppDataValidationException.class, () -> dao.save(course));
		
		assertThat(exception, allOf(
				notNullValue(),
				hasProperty("messages", hasSize(1))
		));

	}
	
	@Order(4)
	@ParameterizedTest
	@CsvFileSource(delimiter = '\t', resources = "/course/test_save_insert_validation.txt")
	void test_save_insert_validation(String name, Level level, int duration, int fees, String description,
			boolean deleted, int messages) {
		
		var course = new Course(name, level, duration, fees, description, deleted);
		
		var exception = assertThrows(AppDataValidationException.class, () -> dao.save(course));
		
		assertThat(exception, allOf(
				notNullValue(),
				hasProperty("messages", hasSize(messages))
		));
	}
	
	@Order(5)
	@ParameterizedTest
	@CsvFileSource(delimiter = '\t', resources = "/course/course-find-by-id.txt")
	void test_find_by_id(int id, String name, Level level, int duration, int fees, String description, boolean deleted) {
		
		var result = dao.findById(id);
		
		assertThat(result, allOf(
				notNullValue(),
				hasProperty("id", is(id)),
				hasProperty("name", is(name)),
				hasProperty("level", is(level)),
				hasProperty("duration", is(duration)),
				hasProperty("description", is(description)),
				hasProperty("deleted", is(deleted))
		));
	}
	
	@Order(6)
	@ParameterizedTest
	@ValueSource(ints = {0, 5, 6})
	void test_find_by_id_not_found(int id) {
		
		var result = dao.findById(id);
		
		assertThat(result, nullValue());
	}
}
