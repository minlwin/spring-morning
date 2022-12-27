package com.jdc.demo.repo;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.entity.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class MemberRepo {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Member create(Member m) {
		
		em.persist(m);
		
		return m;
	}
}
