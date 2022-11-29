package com.jdc.demo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jdc.demo.dto.Course;

@Component
public class CourseDao {
	
	@Autowired
	private DataSource dataSource;

	public List<Course> getAll() {
		
		List<Course> list = new ArrayList<>();
		var sql = "select * from course";
		
		try(var conn = dataSource.getConnection();
				var stmt = conn.createStatement()) {
			
			var result = stmt.executeQuery(sql);
			
			while(result.next()) {
				list.add(new Course(
						result.getInt("id"), 
						result.getString("name"), 
						result.getInt("level"), 
						result.getInt("duration"), 
						result.getInt("fees"), 
						result.getString("description"), 
						result.getBoolean("deleted")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
