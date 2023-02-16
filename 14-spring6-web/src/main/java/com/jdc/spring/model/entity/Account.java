package com.jdc.spring.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NonNull
	@Column(nullable = false)
	private String name;
	@NonNull
	@Column(nullable = false, unique = true)
	private String email;
	@NonNull
	@Column(nullable = false)
	private String password;
	@NonNull
	@Column(nullable = false)
	private Role role;
	
	public enum Role {
		Member, Admin
	}
}
