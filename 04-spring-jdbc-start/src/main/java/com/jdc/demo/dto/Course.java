package com.jdc.demo.dto;

public record Course(
		int id,
		String name,
		int level,
		int duration,
		int fees,
		String description,
		Boolean deleted
		) {

}
