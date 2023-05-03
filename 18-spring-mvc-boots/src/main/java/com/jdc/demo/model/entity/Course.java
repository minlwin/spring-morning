package com.jdc.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@TableGenerator(name = "course_seq")
public class Course {

	@Id
	@GeneratedValue(generator = "course_seq")
	private int id;
	
	@NotBlank(message = "Please enter course name.")
	@Column(nullable = false, unique = true)
	private String name;
	
	@Min(value = 1, message = "Please enter duration in month.")
	private int months;
	
	@Min(value = 1, message = "Please enter course fees.")
	private int fees;
	
	@NotNull(message = "Please select course level.")
	private Level level;
	
	public enum Level {
		Basic, Intermediate, Advance
	}
}
