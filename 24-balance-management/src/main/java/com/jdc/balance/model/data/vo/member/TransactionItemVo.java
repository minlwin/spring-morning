package com.jdc.balance.model.data.vo.member;

import lombok.Data;

@Data
public class TransactionItemVo {

	private String itemName;

	private int unitPrice;

	private int quantity;

}