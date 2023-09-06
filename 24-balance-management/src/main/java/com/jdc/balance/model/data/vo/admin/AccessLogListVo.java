package com.jdc.balance.model.data.vo.admin;

import java.time.LocalDateTime;

import com.jdc.balance.model.data.entity.consts.AccessType;

import lombok.Data;

@Data
public class AccessLogListVo {

	private long id;

	private AccessType accessType;

	private String status;

	private String loginId;

	private LocalDateTime accessAt;

	private int countPerDay;

}