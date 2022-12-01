package com.jdc.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.jdc.demo.dto.Course;

@Repository
@Qualifier("usingNamedParameter")
public class CourseNamedDao implements CourseDao{
	
	private SimpleJdbcInsert insert;
	private NamedParameterJdbcTemplate template;
	private RowMapper<Course> rowMapper;
	
	public CourseNamedDao(DataSource dataSource) {
		insert = new SimpleJdbcInsert(dataSource)
				.withTableName("course")
				.usingGeneratedKeyColumns("id")
				.usingColumns("name", "level", "duration", "fees", "description", "deleted");
		
		template = new NamedParameterJdbcTemplate(dataSource);
		rowMapper = new DataClassRowMapper<>(Course.class);
	}

	@Override
	public List<Course> getAll() {
		return template.query("select * from course", rowMapper);
	}

	@Override
	public int insert(Course course) {
		return insert.executeAndReturnKey(new BeanPropertySqlParameterSource(course)).intValue();
	}

	@Override
	public int update(Course course) {
		var sql = """
			update course set name = :name, level = :level, duration = :duration,
			fees = :fees, description = :description, deleted = :deleted where id = :id""";
		
		template.update(sql, new BeanPropertySqlParameterSource(course));
		
		return course.id();
	}

	@Override
	public void deleteById(int id) {
		template.update("update course set deleted = true where id = :id", Map.of("id", id));
	}

	@Override
	public long findCountByLevel(int level) {
		return template.queryForObject(
				"select count(id) from course where level = :level", 
				Map.of("level", level), Long.class);
	}

	@Override
	public Course findById(int id) {
		return template.queryForObject("select * from course where id = :id", Map.of("id", id), rowMapper);
	}

	@Override
	public List<Course> search(Integer level, String name, Boolean deleted) {
		
		var sb = new StringBuffer("select * from course where 1 = 1");
		var params = new HashMap<String, Object>();
		
		if(null != level && level > 0) {
			sb.append(" and level = :level");
			params.put("level", level);
		}
		
		if(StringUtils.hasLength(name)) {
			sb.append(" and lower(name) like :name");
			params.put("name", name.toLowerCase().concat("%"));
		}
		
		if(null != deleted) {
			sb.append(" and deleted = :deleted");
			params.put("deleted", deleted);
		}
		
		return template.query(sb.toString(), params, rowMapper);
	}

}
