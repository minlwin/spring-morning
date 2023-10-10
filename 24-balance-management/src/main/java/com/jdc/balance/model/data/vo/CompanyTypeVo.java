package com.jdc.balance.model.data.vo;

import com.jdc.balance.model.data.entity.CompanyType;

import lombok.Data;

@Data
public class CompanyTypeVo {

	private int id;

	private String name;

	private int maxEmployee;

	private int maxProject;
	
	public static CompanyTypeVo from(CompanyType entity) {
		var dto = new CompanyTypeVo();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setMaxEmployee(entity.getMaxEmployee());
		dto.setMaxProject(entity.getMaxProject());
		return dto;
	}

}