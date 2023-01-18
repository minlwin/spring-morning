package com.jdc.morning.listener;

import java.time.LocalDateTime;

import com.jdc.morning.entity.BusinessAction;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class BusinessActionListener {

	@PrePersist
	public void atCreation(Object entity) {
		if(entity instanceof BusinessAction action) {
			action.setCreateAt(LocalDateTime.now());
		}
	}
	
	@PreUpdate
	public void adModification(Object entity) {
		if(entity instanceof BusinessAction action) {
			action.setUpdateAt(LocalDateTime.now());
		}
	}
}
