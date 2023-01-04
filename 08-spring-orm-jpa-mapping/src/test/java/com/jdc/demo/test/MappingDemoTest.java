package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.entity.Member;
import com.jdc.demo.repo.MemberRepo;

@SpringJUnitConfig(locations = "classpath:/application.xml")
@Sql(statements = {
		"set foreign_key_checks = 0",
		"truncate table jpamember",
		"set foreign_key_checks = 1",
})
public class MappingDemoTest {

	@Autowired
	private MemberRepo repo;
	
	@Test
	void test_create() {
		var member = new Member("Thidar", "091811711", "thidar@gmail.com");
		member = repo.create(member);
		assertEquals(1, member.getId());
	}
}
