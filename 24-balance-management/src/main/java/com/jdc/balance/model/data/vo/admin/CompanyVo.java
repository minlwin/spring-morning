package com.jdc.balance.model.data.vo.admin;

import com.jdc.balance.model.data.entity.Company;
import com.jdc.balance.model.data.vo.CompanyTypeVo;

import lombok.Data;

@Data
public class CompanyVo {

	private CompanyTypeVo type;
	private String name;
	private String phone;
	
	public static CompanyVo from(Company entity) {
		var dto = new CompanyVo();
		dto.setName(entity.getName());
		dto.setPhone(entity.getPhone());
		dto.setType(CompanyTypeVo.from(entity.getType()));
		return dto;
	}

}