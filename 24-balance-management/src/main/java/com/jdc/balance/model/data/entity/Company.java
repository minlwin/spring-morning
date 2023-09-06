package com.jdc.balance.model.data.entity;

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
@Table(name = "COMPANY")
@SequenceGenerator(name = "seq_company", allocationSize = 1)
public class Company {

	@Id
	@GeneratedValue(generator = "seq_company")
	private long id;

	@Column(nullable = false)
	private String name;

	@ManyToOne(optional = false)
	private CompanyType type;

	@Column(nullable = false)
	private String phone;

	private AuditInfo audit;

}