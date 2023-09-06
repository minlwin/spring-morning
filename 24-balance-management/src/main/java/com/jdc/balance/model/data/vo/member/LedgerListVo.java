package com.jdc.balance.model.data.vo.member;

import com.jdc.balance.model.data.entity.consts.BalanceType;

import lombok.Data;

@Data
public class LedgerListVo {

	private long id;

	private BalanceType type;

	private String name;

	private boolean deleted;

}