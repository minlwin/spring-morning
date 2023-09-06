package com.jdc.balance.model.data.vo.member;

import com.jdc.balance.model.data.entity.consts.MemberStatus;
import com.jdc.balance.model.data.entity.consts.Role;

import lombok.Data;

@Data
public class EmployeeListVo {

	private long id;

	private String name;

	private Role role;

	private String email;

	private String phone;

	private MemberStatus status;

}