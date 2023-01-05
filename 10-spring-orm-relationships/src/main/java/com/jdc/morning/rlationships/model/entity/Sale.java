package com.jdc.morning.rlationships.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "sale_seq")
public class Sale {

	@Id
	@GeneratedValue(generator = "sale_seq")
	private Long id;
	private LocalDateTime saleTime;
	
	@ManyToOne
	private Account customer;
	
	@OneToMany
	@JoinColumn(name = "sale_id")
	private List<SaleDetails> details;
}
