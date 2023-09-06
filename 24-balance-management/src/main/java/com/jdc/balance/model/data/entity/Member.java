package com.jdc.balance.model.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ACCOUNT_MEMBER")
public class Member extends Account {

	@ManyToOne(optional = false)
	private Company company;

}