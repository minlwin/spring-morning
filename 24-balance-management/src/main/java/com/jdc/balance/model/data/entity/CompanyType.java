package com.jdc.balance.model.data.entity;

import com.jdc.balance.model.data.entity.embedded.AuditInfo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "COMPANY_TYPE")
@SequenceGenerator(name = "seq_company_type", allocationSize = 1)
public class CompanyType {

	@Id
	@GeneratedValue(generator = "seq_company_type")
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, name = "max_employee")
	private int maxEmployee;

	@Column(nullable = false, name = "min_employee")
	private int minEmployee;

	@Column(nullable = false, name = "subscription_fees")
	private int subscriptionFees;

	private AuditInfo audit;

}