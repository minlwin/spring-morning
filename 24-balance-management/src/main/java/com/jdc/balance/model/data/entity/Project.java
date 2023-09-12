package com.jdc.balance.model.data.entity;

import java.util.List;

import com.jdc.balance.model.data.entity.embedded.AuditInfo;
import com.jdc.balance.model.data.entity.embedded.Contact;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PROJECT")
@SequenceGenerator(name = "seq_project", allocationSize = 1)
public class Project {

	@Id
	@GeneratedValue(generator = "seq_project")
	private long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String type;

	@Column(nullable = false, name = "dica_number")
	private String dicaNum;

	private Contact contact;

	private AuditInfo audit;
	
	@OneToMany(mappedBy = "project")
	private List<ProjectMember> members;
	
	@OneToMany(mappedBy = "project")
	private List<Transaction> transactions;

}