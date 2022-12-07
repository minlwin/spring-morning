package com.jdc.demo.dao.dto;

import java.time.LocalDate;

public record Registration(
		int id,
		Classes classes,
		Account student,
		LocalDate registDate
		) {

	public Registration withId(int id) {
		return new Registration(id, classes, student, registDate);
	}

}
