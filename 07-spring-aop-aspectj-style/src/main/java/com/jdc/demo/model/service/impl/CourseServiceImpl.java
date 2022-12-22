package com.jdc.demo.model.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.jdc.demo.model.dto.Course;
import com.jdc.demo.model.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	private JdbcTemplate template;
	private SimpleJdbcInsert insert;
	
	public CourseServiceImpl(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
		insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("COURSE");
		insert.setGeneratedKeyName("id");
	}

	@Override
	public int save(Course c) {
		return c.id() == 0 ? insert(c) : update(c);
	}

	private int insert(Course c) {
		var params = new HashMap<String, Object>();
		params.put("name", c.name());
		params.put("duration", c.duration());
		params.put("fees", c.fees());
		
		return insert.execute(params);
	}

	private int update(Course c) {
		return template.update("update course set name = ?, duration = ?, fees = ? where id = ?", 
				c.name(), c.duration(), c.fees(), c.id());
	}

	@Override
	public Course findById(int id) {
		return template.queryForObject("select * from course where id = ?", 
				new DataClassRowMapper<Course>(Course.class), id);
	}

	@Override
	public List<Course> findAll() {
		return template.query("select * from course", new DataClassRowMapper<Course>(Course.class));
	}

}
