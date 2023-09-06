package com.jdc.balance.model.data.vo.admin;

import com.jdc.balance.model.data.vo.CompanyTypeVo;

import lombok.Data;

@Data
public class CompanyVo {

	private CompanyTypeVo type;

	private String name;

	private String phone;

}