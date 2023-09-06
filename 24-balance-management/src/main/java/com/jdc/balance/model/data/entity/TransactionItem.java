package com.jdc.balance.model.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TRANSACTION_ITEM")
@SequenceGenerator(name = "seq_transaction_item", allocationSize = 1)
public class TransactionItem {

	@Id
	@GeneratedValue(generator = "seq_transaction_item")
	private long id;

	@ManyToOne(optional = false)
	private Transaction transaction;

	@Column(nullable = false, name = "item_name")
	private String itemName;

	@Column(nullable = false, name = "unit_price")
	private int unitPrice;

	@Column(nullable = false)
	private int quantity;

}