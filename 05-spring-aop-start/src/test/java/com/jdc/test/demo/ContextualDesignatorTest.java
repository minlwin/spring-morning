package com.jdc.test.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.BaseDao;
import com.jdc.demo.dao.dto.Account;

@SpringJUnitConfig(locations = "classpath:/contexual-demo.xml")
public class ContextualDesignatorTest {

	@Autowired
	@Qualifier("account")
	private BaseDao<Account> dao;
	
	@Test
	void test() {
		dao.create(new Account(1, "Aung Aung", "0918178272", "aung@gmail.com"));
	}
}
