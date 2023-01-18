package com.jdc.morning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.morning.entity.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
public class FindByIdTest {

	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Transactional(isolation = Isolation.READ_COMMITTED)
	void demo() {
		
		var bean1 = em.find(Account.class, 1);
		
		em.refresh(bean1);
		
		System.out.println(bean1.getName());
		
		bean1.setEmail("updated@gmail.com");
		
		em.flush();
		
		System.out.println(bean1.getEmail());
	}
}
