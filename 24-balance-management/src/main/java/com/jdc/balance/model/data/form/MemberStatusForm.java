package com.jdc.balance.model.data.form;

import com.jdc.balance.model.data.entity.consts.Role;

import lombok.Data;

@Data
public class MemberStatusForm {

	private String email;
	private Role role;

}