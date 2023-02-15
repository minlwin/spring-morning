package com.jdc.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private Role role;
	
	public enum Role {
		Admin, Member
	}
}
