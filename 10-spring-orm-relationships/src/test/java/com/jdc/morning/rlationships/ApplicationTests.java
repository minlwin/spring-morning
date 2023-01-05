package com.jdc.morning.rlationships;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.morning.rlationships.model.entity.Account;
import com.jdc.morning.rlationships.model.entity.Account.Role;
import com.jdc.morning.rlationships.model.service.AccountService;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	private AccountService service;
	
	@Test
	void create_test() {
		var input = new Account("Thidar", "thidar@gmail.com", Role.Member);
		
		var result = service.create(input);
		
		assertThat(result, allOf(
				notNullValue(),
				hasProperty("id", is(1)),
				hasProperty("name", is("Thidar")),
				hasProperty("email", is("thidar@gmail.com"))
			));
	}

}
