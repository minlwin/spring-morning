package com.jdc.registration.model.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.registration.model.dto.Course;
import com.jdc.registration.model.dto.Course.Level;

public class CourseDao {

	// Dependency
	private DataSource dataSource;

	public CourseDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int save(Course dto) {
		if (dto.getId() == 0) {
			// Insert
			return insert(dto);
		}
		return update(dto);
	}

	private int update(Course dto) {

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

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto.getId();
	}

	private int insert(Course dto) {

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
				return rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	public Course findById(int id) {
		
		var sql = "select * from course where id = ?";
		
		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(sql)) {
			
			stmt.setInt(1, id);
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<Course> search(Level level, String name) {
		// TODO Auto-generated method stub
		return null;
	}

}