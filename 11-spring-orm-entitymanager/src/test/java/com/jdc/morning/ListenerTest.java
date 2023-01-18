package com.jdc.morning;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.morning.entity.BusinessAction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(value = OrderAnnotation.class)
public class ListenerTest {

	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Order(1)
	@Transactional
	void create() {
		var action = new BusinessAction("Action 1", 1000);
		em.persist(action);
		
		System.out.println(action.getCreateAt());
	}
	
	@Test
	@Order(2)
	@Transactional
	void update() {
		
		var action = em.find(BusinessAction.class, 1);
		action.setAmount(2000);
	}
}
