package com.jdc.morning.rlationships.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Contact {

	@Id
	private Integer id;
	private String phone;
	private String streetAddress;
	private String township;
	
	@OneToOne
	private Account account;
}
