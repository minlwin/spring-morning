package com.jdc.shop.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	
	private Status status;
	private List<String> messages;

	public enum Status {
		Validation, Platform, Business
	}
}
