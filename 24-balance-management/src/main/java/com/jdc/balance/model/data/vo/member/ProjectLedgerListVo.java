package com.jdc.balance.model.data.vo.member;

import com.jdc.balance.model.data.entity.consts.BalanceType;

import lombok.Data;

@Data
public class ProjectLedgerListVo {

	private long id;

	private String ledger;

	private BalanceType type;

	private long monthTotal;

	private long yearTotal;

	private long allTotal;

}