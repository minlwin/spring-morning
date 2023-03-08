package com.jdc.spring.model.dto;

import java.util.List;

public record MessageDto(
		Status status,
		List<String> messages
		) {

	public enum Status {
		Business, Platform
	}
}
