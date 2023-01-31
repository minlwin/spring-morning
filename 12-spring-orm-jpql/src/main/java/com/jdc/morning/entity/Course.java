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
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.StoredProcedureParameter;
import lombok.Data;

@Data
@Entity

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

@NamedQuery(
		name = "Course.searchForList", 
		query = """
				select new com.jdc.morning.dto.CourseIdWithName(c.id, c.name, c.level) 
				from Course c where c.level = :level""")

@NamedNativeQuery(
		name = "Course.nativeFindByLevel",
		query = "select * from course where level = :level",
		resultClass = Course.class)
@NamedNativeQuery(
		name = "Course.native.findByLevelForList",
		query = "select id, name, level from course where level = :level",
		resultSetMapping = "Course.nativeFindByLevelForListResult"
)
@NamedStoredProcedureQuery(
		name = "Course.store.findByLevel",
		procedureName = "find_by_level",
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "level_in", type = Integer.class)
		},
		resultClasses = Course.class
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
