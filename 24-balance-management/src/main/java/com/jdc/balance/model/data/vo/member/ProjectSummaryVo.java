package com.jdc.balance.model.data.vo.member;

import lombok.Data;

@Data
public class ProjectSummaryVo {

	private long monthlyCredit;

	private long monthlyDebit;

	private long yearlyCredit;

	private long yearlyDebit;

}