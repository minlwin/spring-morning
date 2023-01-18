package com.jdc.morning.entity;

import java.time.LocalDateTime;

import com.jdc.morning.listener.BusinessActionListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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
@EntityListeners(value = BusinessActionListener.class)
public class BusinessAction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NonNull
	private String name;
	@NonNull
	private Integer amount;
	
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
}
