package com.jdc.balance.model.data.vo;

import java.time.LocalDate;

import com.jdc.balance.model.data.entity.consts.MemberStatus;
import com.jdc.balance.model.data.entity.consts.Role;

import lombok.Data;

@Data
public class MemberVo {

	private String code;

	private String name;

	private String email;

	private Role role;

	private MemberStatus status;

	private LocalDate registAt;

	public String companyName;

}