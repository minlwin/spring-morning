package com.jdc.morning.dto;

import com.jdc.morning.entity.Course.Level;

public record CourseIdWithName(
	int id,
	String name,
	Level level) {
	
	public CourseIdWithName(int id, String name, int ordinal) {
		this(id, name, Level.values()[ordinal]);
	}
}
