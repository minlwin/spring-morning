package com.jdc.morning.rlationships.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.morning.rlationships.model.entity.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class AccountService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Account create(Account data) {
		entityManager.persist(data);
		return data;
	}
}
