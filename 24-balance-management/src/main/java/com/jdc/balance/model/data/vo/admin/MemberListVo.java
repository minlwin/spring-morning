package com.jdc.balance.model.data.vo.admin;

import java.time.LocalDateTime;

import com.jdc.balance.model.data.vo.MemberVo;

import lombok.Data;

@Data
public class MemberListVo {

	private MemberVo member;

	private LocalDateTime lastLogin;

}