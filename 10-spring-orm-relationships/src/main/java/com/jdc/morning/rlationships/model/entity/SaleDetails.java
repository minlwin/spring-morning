package com.jdc.morning.rlationships.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "details")
@SequenceGenerator(name = "sale_details_seq")
public class SaleDetails {

	@Id
	@GeneratedValue(generator = "sale_details_seq")
	private Long id;
	
	@ManyToOne
	private Product product;
	private Integer quentity;
	
	@ManyToOne
	private Sale sale;
}
