package com.jdc.balance.model.data.form;

import lombok.Data;

@Data
public class MemberStatusForm {

	public MemberStatusForm() {
	}

	private String email;

	private Status status;

	public enum Status {
		Apply,
		Owner,
		Employee,
		Manager
	}

}