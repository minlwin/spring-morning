package com.jdc.balance.model.data.vo.member;

import java.time.LocalDate;

import com.jdc.balance.model.data.entity.consts.BalanceType;

import lombok.Data;

@Data
public class BalanceListVo {

	private long id;

	private BalanceType type;

	private String ledger;

	private LocalDate issueAt;

	private String employee;

	private int credit;

	private int debit;

	private int balance;

}