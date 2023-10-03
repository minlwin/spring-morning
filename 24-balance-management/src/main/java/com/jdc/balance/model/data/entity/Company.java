package com.jdc.balance.model.data.entity;

import java.util.ArrayList;
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
@Table(name = "COMPANY")
@EntityListeners(value = AuditingEntityListener.class)
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
	
	@ManyToOne(optional = false)
	private Member owner;

	private AuditInfo audit = new AuditInfo();
	
	@OneToMany(mappedBy = "company")
	private List<Member> members = new ArrayList<>();

}