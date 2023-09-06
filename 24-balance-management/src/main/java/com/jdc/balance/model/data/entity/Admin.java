package com.jdc.balance.model.data.entity;

import com.jdc.balance.model.data.entity.consts.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "ACCOUNT_ADMIN")
public class Admin extends Account {

	public Admin() {
		setRole(Role.Admin);
	}
}