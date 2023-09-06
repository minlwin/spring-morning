package com.jdc.balance.model.data.vo.admin;

import com.jdc.balance.model.data.vo.MemberVo;

import lombok.Data;

@Data
public class MemberDetailsVo {

	private MemberVo member;

	private CompanyVo company;

}