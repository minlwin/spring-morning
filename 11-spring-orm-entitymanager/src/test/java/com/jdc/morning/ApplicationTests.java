package com.jdc.morning;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.morning.entity.Account;
import com.jdc.morning.entity.Account.Role;
import com.jdc.morning.entity.Profile;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
@TestMethodOrder(value = OrderAnnotation.class)
@Rollback(false)
class ApplicationTests {
	
	@PersistenceContext
	private EntityManager em;

	
	@Test
	@Order(2)
	@Transactional
	void test_find() {
		
		var entity = em.find(Account.class, 1);
		
		assertThat(entity, allOf(
			hasProperty("id", is(1)),
			hasProperty("name", is("Admin User")),
			hasProperty("email", is("admin@gmail.com")),
			hasProperty("role", is(Role.Admin))));
		
		em.remove(entity);
	}
	
	@Test
	@Transactional
	@Disabled
	@Order(1)
	void test_persist() {
		
		var account = new Account("Thidar", "thidar@gmail.com", Role.Member);
		
		var profile = new Profile();
		profile.setPhone("098181717171");
		
		account.setProfile(profile);
		profile.setAccount(account);
		
		em.persist(account);

		assertEquals(3, account.getId());	
	}
	

}
