package com.jdc.shop.model.dto;

import java.util.List;

public record Message(
		Status status,
		List<String> messages
		) {

	public enum Status {
		Validation, Platform
	}
}
