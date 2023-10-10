package com.jdc.balance.model.data.vo;

import java.time.LocalDate;

import com.jdc.balance.model.data.entity.Member;
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
	
	public static MemberVo from(Member entity) {
		var dto = new MemberVo();
		dto.setCode("MEM%04d".formatted(entity.getId()));
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setRole(entity.getRole());
		dto.setStatus(entity.getStatus());
		dto.setRegistAt(entity.getRegistAt());
		dto.setCompanyName(null != entity.getCompany() ? entity.getCompany().getName() : "Undefine");
		return dto;
	}

}