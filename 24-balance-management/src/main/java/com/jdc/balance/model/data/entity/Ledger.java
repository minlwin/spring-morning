package com.jdc.balance.model.data.entity;

import com.jdc.balance.model.data.entity.consts.BalanceType;
import com.jdc.balance.model.data.entity.embedded.AuditInfo;

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
@Table(name = "LEDGER")
@SequenceGenerator(name = "seq_ledger", allocationSize = 1)
public class Ledger {

	@Id
	@GeneratedValue(generator = "seq_ledger")
	private long id;

	@ManyToOne(optional = false)
	private Company company;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private BalanceType type;

	private AuditInfo audit;

}