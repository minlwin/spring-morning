package com.jdc.morning.entity;

import com.jdc.morning.dto.CourseIdWithName;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SqlResultSetMapping;
import lombok.Data;

@Data
@Entity
@NamedQuery(
		name = "Course.searchForList", 
		query = """
				select new com.jdc.morning.dto.CourseIdWithName(c.id, c.name, c.level) 
				from Course c where c.level = :level""")

@NamedNativeQuery(
		name = "Course.nativeFindByLevel",
		query = "select * from course where level = ?1",
		resultClass = Course.class)

@SqlResultSetMapping(
		name = "Course.nativeFindByLevelForListResult",
		classes = @ConstructorResult(
				targetClass = CourseIdWithName.class,
				columns = {
					@ColumnResult(name = "id"),
					@ColumnResult(name = "name"),
					@ColumnResult(name = "level"),
				}
		))
@NamedNativeQuery(
		name = "Course.native.findByLevelForList",
		query = "select id, name, level from course where level = ?1",
		resultSetMapping = "Course.native.findByLevelForListResult"
)
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Level level;
	private String description;
	private int months;
	
	public enum Level {
		Basic, Advance
	}
}
