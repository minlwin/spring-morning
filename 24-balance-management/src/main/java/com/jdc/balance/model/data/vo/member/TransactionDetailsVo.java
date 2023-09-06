package com.jdc.balance.model.data.vo.member;

import java.util.List;

import lombok.Data;

@Data
public class TransactionDetailsVo {

	private TransactionListVo transaction;

	private List<TransactionItemVo> items;

}