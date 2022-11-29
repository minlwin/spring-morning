package com.jdc.demo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdc.demo.dto.Course;

@Repository
public class CourseSpringDao {

	private JdbcTemplate template;
	
	public CourseSpringDao(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}
	
	public List<Course> getAll() {
		return template.query("select * from course", 
				new DataClassRowMapper<>(Course.class));
	}
}
