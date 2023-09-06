package com.jdc.balance.model.data.entity.embedded;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Contact implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String person;

	@Column(nullable = false)
	private String position;

	@Column(nullable = false)
	private String phone;

	@Column(nullable = false)
	private String email;

}