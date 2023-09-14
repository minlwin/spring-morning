package com.jdc.balance.model.data.entity;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jdc.balance.model.data.entity.consts.MemberStatus;
import com.jdc.balance.model.data.entity.consts.Role;
import com.jdc.balance.model.data.entity.embedded.AuditInfo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ACCOUNT")
@EntityListeners(value = AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "seq_account", allocationSize = 1)
public abstract class Account {
	
	@Id
	@GeneratedValue(generator = "seq_account")
	private long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private Role role;

	private MemberStatus status;

	@Column(name = "regist_at")
	private LocalDate registAt;

	private AuditInfo audit;

}