package com.jdc.registration.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.registration.AppDataValidationException;
import com.jdc.registration.model.ClassesRepo;
import com.jdc.registration.model.dto.Classes;
import com.jdc.registration.model.dto.Course;
import com.jdc.registration.model.dto.Course.Level;
import com.jdc.registration.model.dto.Teacher;
import com.jdc.registration.model.form.ClassesForm;

public class ClassesDao implements ClassesRepo{

	// Dependency
	private DataSource dataSource;

	public ClassesDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public int save(ClassesForm dto) {
		
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
				where cl.id = ?""";
		
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
		
		var sql = "update classes set deleted = ? where id = ?";
		
		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(sql)) {
			
			stmt.setBoolean(1, true);
			stmt.setInt(2, id);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new AppDataValidationException(e.getMessage(), e);
		}
	}

	@Override
	public List<Classes> search(String teacherName, String courseName, Date from, Date to, Boolean deleted) {
		var sql = new StringBuffer("""
				select cl.id, cl.start_date, cl.deleted, t.id, t.name, 
				c.id, c.name, c.level, c.duration, c.fees, c.description, c.deleted
				from classes cl join course c on cl.course_id = c.id join teacher t on cl.teacher_id = t.id 
				where 1 = 1""");
		var params = new ArrayList<Object>();
		var result = new ArrayList<Classes>();
		
		if(null != teacherName && !teacherName.isEmpty()) {
			sql.append(" and lower(t.name) like ?");
			params.add(teacherName.toLowerCase().concat("%"));
		}

		if(null != courseName && !courseName.isEmpty()) {
			sql.append(" and lower(c.name) like ?");
			params.add(courseName.toLowerCase().concat("%"));
		}
		
		if(null != from) {
			sql.append(" and cl.start_date >= ?");
			params.add(new java.sql.Date(from.getTime()));
		}
		
		if(null != to) {
			sql.append(" and cl.start_date <= ?");
			params.add(new java.sql.Date(to.getTime()));
		}

		if(null != deleted) {
			sql.append(" and cl.deleted = ?");
			params.add(deleted);
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

	private void validate(ClassesForm dto) {
		
		if(null == dto.getStartDate()) {
			throw new AppDataValidationException("Please enter start date.");
		}
		
		if(dto.getCourseId() == 0) {
			throw new AppDataValidationException("Please select course.");
		}
		
		if(dto.getTeacherId() == 0) {
			throw new AppDataValidationException("Please select teacher.");
		}
	}
	
	private int update(ClassesForm dto) {
		
		var sql = "update classes set start_date = ?, course_id = ?, teacher_id = ?, deleted = ? where id = ?";
		
		try (var conn = dataSource.getConnection(); 
				var stmt = conn.prepareStatement(sql.toString())) {
			
			stmt.setDate(1, new java.sql.Date(dto.getStartDate().getTime()));
			stmt.setInt(2, dto.getCourseId());
			stmt.setInt(3, dto.getTeacherId());
			stmt.setBoolean(4, dto.isDeleted());
			stmt.setInt(5, dto.getId());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new AppDataValidationException(e.getMessage(), e);
		}

		return dto.getId();
	}

	private int create(ClassesForm dto) {
		var sql = "insert into classes(start_date, course_id, teacher_id, deleted) values (?, ?, ?, ?)";
		
		try (var conn = dataSource.getConnection(); 
				var stmt = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS)) {
			
			stmt.setDate(1, new java.sql.Date(dto.getStartDate().getTime()));
			stmt.setInt(2, dto.getCourseId());
			stmt.setInt(3, dto.getTeacherId());
			stmt.setBoolean(4, dto.isDeleted());
			
			stmt.executeUpdate();
			
			var rs = stmt.getGeneratedKeys();
			
			while(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			throw new AppDataValidationException(e.getMessage(), e);
		}
		return 0;
	}
	
	private Classes getData(ResultSet rs) throws SQLException {

		var data = new Classes();
		data.setId(rs.getInt(1));
		data.setStartDate(rs.getDate(2));
		data.setDeleted(rs.getBoolean(3));
		
		var teacher = new Teacher();
		teacher.setId(4);
		teacher.setName(rs.getString(5));
		data.setTeacher(teacher);
		
		var course = new Course();
		course.setId(rs.getInt(6));
		course.setName(rs.getString(7));
		course.setLevel(Level.valueOf(rs.getString(8)));
		course.setDuration(rs.getInt(9));
		course.setFees(rs.getInt(10));
		course.setDescription(rs.getString(11));
		course.setDeleted(rs.getBoolean(12));
		data.setCourse(course);
		
		return data;
	}

}
