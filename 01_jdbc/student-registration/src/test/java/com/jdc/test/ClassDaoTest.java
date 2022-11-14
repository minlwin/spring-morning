package com.jdc.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.registration.AppDataValidationException;
import com.jdc.registration.DataSourceManager;
import com.jdc.registration.model.ClassesRepo;
import com.jdc.registration.model.dao.ClassesDao;
import com.jdc.registration.model.form.ClassesForm;
import com.jdc.test.utils.DateUtils;
import com.jdc.test.utils.DbUtils;

@TestMethodOrder(OrderAnnotation.class)
public class ClassDaoTest {

	ClassesRepo repository;
	static DataSource dataSource;
	
	@BeforeAll
	static void prepareOnce() {
		dataSource = DataSourceManager.getDataSource();
		
		DbUtils.truncate("classes", "teacher", "course");
		
		// Prepare Course
		DbUtils.execute(
				"insert into course values (1,'Java Basic', 'Entry',90,300000, 'Foundation for Java Programming', false);",
				"insert into course values (2,'Spring Framework', 'Intermediate',180,500000, 'Framework course for Java', false);",
				"insert into course values (3,'Angular Framework', 'Advance',120,300000, 'Front End Framework Course', false);",
				"insert into course values (4,'Flutter', 'Intermediate',180,300000, 'Mobile Development Course', true);	"
				);
		
		// Prepare Teacher
		DbUtils.execute(
				"insert into teacher values (1, 'Aung Aung')",
				"insert into teacher values (2, 'Maung Maung')",
				"insert into teacher values (3, 'Thidar')"
		);
	}
	
	@BeforeEach
	void prepare() {
		repository = new ClassesDao(dataSource);
		
		// Truncate Classes Table
		DbUtils.truncate("classes");
		
		// Prepare Classes Data
		DbUtils.execute(
				"insert into classes values (1, 1, 1, '2022-10-01', true)",
				"insert into classes values (2, 2, 2, '2022-11-01', false)",
				"insert into classes values (3, 3, 3, '2022-12-01', false)"
		);
	}
	
	@Order(1)
	@ParameterizedTest
	@CsvFileSource(delimiter = '\t', resources = "/classes/test_validation.txt")
	void test_validation(int courseId, int teacherId, String startDate, boolean deleted, String message) {
		var form = new ClassesForm(courseId, teacherId, DateUtils.parse(startDate), deleted);
		
		var exception = assertThrows(AppDataValidationException.class, () -> repository.save(form));
		
		assertThat(exception, allOf(
				notNullValue(),
				hasProperty("message", is(message))
				));
		
	}
	
	
	@Order(2)
	@ParameterizedTest
	@CsvFileSource(delimiter = '\t', resources = "/classes/test_insert.txt")
	void test_insert(int id, int courseId, String courseName, int teacherId, String teacherName, String startDate, boolean deleted) {
		var form = new ClassesForm(courseId, teacherId, DateUtils.parse(startDate), deleted);
		
		var insertResult = repository.save(form);
		assertThat(insertResult, is(id));
		
		var dto = repository.findById(id);
		assertThat(dto, allOf(
				hasProperty("id", is(id)),
				hasProperty("startDate", is(DateUtils.parse(startDate))),
				hasProperty("deleted", is(deleted)),
				hasProperty("teacher", allOf(
						notNullValue(),
						hasProperty("id", is(teacherId)),
						hasProperty("name", is(teacherName))
						)),
				hasProperty("course", allOf(
						notNullValue(),
						hasProperty("id", is(courseId)),
						hasProperty("name", is(courseName))
						))
				));		
	}
	
	@Order(3)
	@ParameterizedTest
	@CsvFileSource(delimiter = '\t', resources = "/classes/test_update.txt")
	void test_update(int id, int courseId, String courseName, int teacherId, String teacherName, String startDate, boolean deleted) {
		var form = new ClassesForm(id, courseId, teacherId, DateUtils.parse(startDate), deleted);
		
		var insertResult = repository.save(form);
		assertThat(insertResult, is(id));
		
		var dto = repository.findById(id);
		assertThat(dto, allOf(
				hasProperty("id", is(id)),
				hasProperty("startDate", is(DateUtils.parse(startDate))),
				hasProperty("deleted", is(deleted)),
				hasProperty("teacher", allOf(
						notNullValue(),
						hasProperty("id", is(teacherId)),
						hasProperty("name", is(teacherName))
						)),
				hasProperty("course", allOf(
						notNullValue(),
						hasProperty("id", is(courseId)),
						hasProperty("name", is(courseName))
						))
				));
	}
	
	@Order(4)
	@ParameterizedTest
	@CsvFileSource(delimiter = '\t', resources = "/classes/test_find_by_id.txt")
	void test_find_by_id(int id, int courseId, String course, int teacherId, String teacher, String startDate, boolean deleted) {
		var result = repository.findById(id);
		
		assertThat(result, allOf(
				hasProperty("id", is(id)),
				hasProperty("startDate", is(DateUtils.parse(startDate))),
				hasProperty("deleted", is(deleted)),
				hasProperty("teacher", allOf(
						notNullValue(),
						hasProperty("id", is(teacherId)),
						hasProperty("name", is(teacher))
						)),
				hasProperty("course", allOf(
						notNullValue(),
						hasProperty("id", is(courseId)),
						hasProperty("name", is(course))
						))
				));
	}
	
	@Order(5)
	@ParameterizedTest
	@ValueSource(ints = {4, 5, 0})
	void test_find_by_id_not_found(int id) {
		var result = repository.findById(id);
		assertThat(result, nullValue());
	}
	
	@Order(6)
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void test_delete(int id) {
		repository.delete(id);
		var result = repository.findById(id);
		assertThat(result, hasProperty("deleted", is(true)));
	}
	
	@Order(7)
	@ParameterizedTest
	@CsvFileSource(delimiter = '\t', resources = "/classes/test_search.txt")
	void test_search(String teacherName, String courseName, String from, String to, Boolean deleted, int size) {
		
		var result = repository.search(teacherName, courseName, DateUtils.parse(from), DateUtils.parse(to), deleted);
		
		assertThat(result, hasSize(size));
	}
}
