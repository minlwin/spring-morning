package com.jdc.registration.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.registration.model.AppDataValidationException;
import com.jdc.registration.model.dto.Course;
import com.jdc.registration.model.dto.Course.Level;

public class CourseDao implements CourseRepo {

	// Dependency
	private DataSource dataSource;

	public CourseDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int save(Course dto) {
		
		validate(dto);
		
		try {
			if (dto.getId() == 0) {
				// Insert
				return insert(dto);
			}
			return update(dto);
		} catch (SQLException e) {
			throw new AppDataValidationException(e.getMessage(), e);
		}
	}

	private void validate(Course dto) {

		if(null == dto) {
			throw new AppDataValidationException("Course must not be null!");
		}
		
		var errors = new ArrayList<String>();
		
		// Name
		if(null == dto.getName() || dto.getName().isBlank()) {
			errors.add("Please enter course name.");
		}
		
		// Level
		if(null == dto.getLevel()) {
			errors.add("Please select level of course.");
		}
		
		// duration
		if(0 == dto.getDuration()) {
			errors.add("Please define duration of course.");
		}

		// fees
		if(0 == dto.getFees()) {
			errors.add("Please define fees of course.");
		}
		
		if(!errors.isEmpty()) {
			throw new AppDataValidationException(errors);
		}
		
	}

	private int update(Course dto) throws SQLException{

		var sql = "update course set name = ?, level = ?, duration = ?, fees = ?, description = ?, deleted = ? where id = ?";

		try (var conn = dataSource.getConnection(); var stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, dto.getName());
			stmt.setString(2, dto.getLevel().name());
			stmt.setInt(3, dto.getDuration());
			stmt.setInt(4, dto.getFees());
			stmt.setString(5, dto.getDescription());
			stmt.setBoolean(6, dto.isDeleted());
			stmt.setInt(7, dto.getId());

			stmt.executeUpdate();

		} 

		return dto.getId();
	}

	private int insert(Course dto) throws SQLException{
		
		var generatedId = 0;

		var sql = "insert into course (name, level, duration, fees, description) values (?, ?, ?, ?, ?)";

		try (var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, dto.getName());
			stmt.setString(2, dto.getLevel().name());
			stmt.setInt(3, dto.getDuration());
			stmt.setInt(4, dto.getFees());
			stmt.setString(5, dto.getDescription());

			stmt.executeUpdate();

			var rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				generatedId = rs.getInt(1);
			}

		} 

		return generatedId;
	}

	@Override
	public Course findById(int id) {
		
		var sql = "select * from course where id = ?";
		
		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(sql)) {
			
			stmt.setInt(1, id);
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				return getData(rs);
			}
			
		} catch (SQLException e) {
			throw new AppDataValidationException(e.getMessage(), e);
		}
		
		return null;
	}
	
	@Override
	public void delete(int id) {
		
		var sql = "update course set deleted = ? where id = ?";
		try (var conn = dataSource.getConnection(); 
				var stmt = conn.prepareStatement(sql)) {
			
			stmt.setBoolean(1, true);
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new AppDataValidationException(e.getMessage(), e);
		}

	}


	@Override
	public List<Course> search(Level level, String name) {
		
		var sql = new StringBuffer("select * from course where 1 = 1");
		var params = new ArrayList<Object>();
		var result = new ArrayList<Course>();
		
		if(null != level) {
			sql.append(" and level = ?");
			params.add(level.name());
		}
		
		if(null != name && !name.isEmpty()) {
			sql.append(" and lower(name) like ?");
			params.add(name.toLowerCase().concat("%"));
		}
		
		try (var conn = dataSource.getConnection(); 
				var stmt = conn.prepareStatement(sql.toString())) {
			
			for(var i = 0; i < params.size(); i ++) {
				stmt.setObject(i + 1, params.get(i));
			}
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				result.add(getData(rs));
			}
			
		} catch (SQLException e) {
			throw new AppDataValidationException(e.getMessage(), e);
		}

		return result;
	}

	private Course getData(ResultSet rs) throws SQLException {
		var dto = new Course();
		
		dto.setId(rs.getInt("id"));
		dto.setName(rs.getString("name"));
		dto.setLevel(Level.valueOf(rs.getString("level")));
		dto.setDuration(rs.getInt("duration"));
		dto.setFees(rs.getInt("fees"));
		dto.setDescription(rs.getString("description"));
		dto.setDeleted(rs.getBoolean("deleted"));
		
		return dto;
	}

}