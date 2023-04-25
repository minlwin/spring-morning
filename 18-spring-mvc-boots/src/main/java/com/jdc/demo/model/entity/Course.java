package com.jdc.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;
import lombok.Data;

@Entity
@Data
@TableGenerator(name = "course_seq")
public class Course {

	@Id
	@GeneratedValue(generator = "course_seq")
	private int id;
	@Column(nullable = false, unique = true)
	private String name;
	private int months;
	private int fees;
}
