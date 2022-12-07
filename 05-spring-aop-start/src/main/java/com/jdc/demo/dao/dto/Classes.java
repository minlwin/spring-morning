package com.jdc.demo.dao.dto;

import java.time.LocalDate;

public record Classes(
		int id,
		Course course,
		Account teacher,
		LocalDate startDate
		) {

}
