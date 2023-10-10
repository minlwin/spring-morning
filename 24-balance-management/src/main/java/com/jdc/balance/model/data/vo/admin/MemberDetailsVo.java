package com.jdc.balance.model.data.vo.admin;

import com.jdc.balance.model.data.entity.Member;
import com.jdc.balance.model.data.vo.MemberVo;

import lombok.Data;

@Data
public class MemberDetailsVo {

	private MemberVo member;

	private CompanyVo company;
	
	public static MemberDetailsVo from(Member entity) {
		var dto = new MemberDetailsVo();
		dto.setMember(MemberVo.from(entity));
		if(null != entity.getCompany()) {
			dto.setCompany(CompanyVo.from(entity.getCompany()));
		}
		return dto;
	}

}