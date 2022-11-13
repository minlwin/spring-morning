package com.jdc.registration.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.registration.AppDataValidationException;
import com.jdc.registration.model.ClassesRepo;
import com.jdc.registration.model.dto.Classes;

public class ClassesDao implements ClassesRepo{

	// Dependency
	private DataSource dataSource;

	public ClassesDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public int save(Classes dto) {
		
		validate(dto);
		
		if(dto.getId() == 0) {
			return create(dto);
		}
		
		return update(dto);
	}

	@Override
	public Classes findById(int id) {
		var sql = """
				select cl.id, cl.start_date, cl.deleted, t.id, t.name, 
				c.id, c.name, c.level, c.duration, c.fees, c.description, c.deleted
				from classes cl join course c on cl.course_id = c.id join teacher t on cl.teacher_id = t.id 
				where cl.id = ?
				""";
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Classes> search(String teacherName, String courseName, Date from, Date to, Boolean deleted) {
		// TODO Auto-generated method stub
		return null;
	}

	private void validate(Classes dto) {
		// TODO Auto-generated method stub
		
	}
	
	private int update(Classes dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int create(Classes dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private Classes getData(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

}
