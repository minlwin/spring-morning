package com.jdc.balance.model.data.vo.member;

import java.time.LocalDate;

import com.jdc.balance.model.data.entity.consts.BalanceType;

import lombok.Data;

@Data
public class TransactionListVo {

	private long id;

	private BalanceType type;

	private int ledgerId;

	private String ledgerName;

	private LocalDate issueAt;

	private int employeeId;

	private String employeeName;

	private String remark;

	private int amount;

}