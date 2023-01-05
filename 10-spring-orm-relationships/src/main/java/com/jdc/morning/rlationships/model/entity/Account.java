package com.jdc.morning.rlationships.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "account_seq")
public class Account {

	@Id
	@GeneratedValue(generator = "account_seq")
	private Integer id;
	
	@NonNull
	@Column(nullable = false)
	private String name;
	@NonNull
	@Column(nullable = false, unique = true)
	private String email;
	private String password;
	@NonNull
	@Column(nullable = false)
	private Role role;
	
	public enum Role {
		Admin, Member
	}
}
