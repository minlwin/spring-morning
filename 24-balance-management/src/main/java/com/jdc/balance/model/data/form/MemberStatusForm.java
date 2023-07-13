package com.jdc.balance.model.data.form;

import java.util.*;

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