package com.jdc.morning.rlationships.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@SequenceGenerator(name = "category_seq")
@RequiredArgsConstructor
@NoArgsConstructor
public class Category {

	@Id
	@GeneratedValue(generator = "category_seq")
	private Integer id;
	@NonNull
	private String name;
}
