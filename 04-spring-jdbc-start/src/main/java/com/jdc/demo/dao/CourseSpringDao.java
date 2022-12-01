package com.jdc.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.jdc.demo.dto.Course;

@Repository
public class CourseSpringDao {

	private JdbcTemplate template;
	private RowMapper<Course> rowMapper = new DataClassRowMapper<>(Course.class);
	
	public CourseSpringDao(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}
	
	public List<Course> getAll() {
		return template.query("select * from course", 
				rowMapper);
	}
	
	public int insert(Course course) {
		return 0;
	}
	
	public int update(Course course) {
		
		template.update("""
			update course set name = ?, level = ?, duration = ?, fees = ?, 
			description = ?, deleted = ? where id = ?
				""", 
				course.name(), 
				course.level(), 
				course.duration(), 
				course.fees(), 
				course.description(),
				course.deleted(),
				course.id());
		
		return course.id();
	}
	
	public void deleteById(int id) {
		template.update("update course set deleted = ? where id = ?", true, id);
	}
	
	public long findCountByLevel(int level) {
		return template.queryForObject(
				"select count(id) from course where level = ?", 
				Long.class, level);
	}
	
	public Course findById(int id) {
		var sql = "select * from course where id = ?";
		return template.queryForObject(sql, rowMapper, id);
	}
	
	public List<Course> search(Integer level, String name, Boolean deleted) {
		
		StringBuilder sb = new StringBuilder("select * from course where 1 = 1");
		var params = new ArrayList<Object>();
		
		if(null != level && level > 0) {
			sb.append(" and level = ?");
			params.add(level);
		}
		
		if(StringUtils.hasLength(name)) {
			sb.append(" and lower(name) like ?");
			params.add(name.toLowerCase().concat("%"));
		}
		
		if(null != deleted) {
			sb.append(" and deleted = ?");
			params.add(deleted);
		}
		
		return template.query(sb.toString(), rowMapper, params.toArray());
	}
}
