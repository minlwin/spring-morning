package com.jdc.demo.service.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Members {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Please Enter name.")
	@Column(nullable = false)
	private String name;
	
	@NotBlank(message = "Please Enter Email Address.")
	@Email(message = "Please enter valid email.")
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@NotNull(message = "Please select role")
	@Column(nullable = false)
	private Role role;
	
	private boolean activated;
	private boolean locked;
	private LocalDate expired;
	
	public enum Role {
		Manager, Employee, Customer
	}
}
