package com.jdc.morning.rlationships.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@SequenceGenerator(name = "product_seq")
public class Product {

	@Id
	@GeneratedValue(generator = "product_seq")
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	@ManyToOne
	private Category category;
	@NonNull
	private Integer price;
}
