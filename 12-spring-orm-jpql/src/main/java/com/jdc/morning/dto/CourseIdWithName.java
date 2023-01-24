package com.jdc.morning.dto;

import com.jdc.morning.entity.Course.Level;

public record CourseIdWithName(
	int id,
	String name,
	Level level) {

}
