package com.jdc.balance.model.data.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jdc.balance.model.data.entity.embedded.AuditInfo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TRANSACTION")
@EntityListeners(value = AuditingEntityListener.class)
@SequenceGenerator(name = "seq_transaction", allocationSize = 1)
public class Transaction {

	@Id
	@GeneratedValue(generator = "seq_transaction")
	private long id;

	@ManyToOne(optional = false)
	private Project project;

	@ManyToOne(optional = false)
	private Ledger ledger;

	@ManyToOne(optional = false)
	private Member member;
	
	@Column(nullable = false, name = "issue_at")
	private LocalDate issueAt;

	private String remark;

	@Column(nullable = false)
	private int amount;
	
	@OneToMany(mappedBy = "transaction")
	private List<TransactionItem> items;

	private AuditInfo audit;

}