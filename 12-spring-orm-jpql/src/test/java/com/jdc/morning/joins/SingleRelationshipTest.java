package com.jdc.morning.joins;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.morning.repo.SectionRepo;

@SpringBootTest
public class SingleRelationshipTest {

	@Autowired
	private SectionRepo repo;
	
	@Test
	void oneEndRelationship() {
		var result = repo.search("Java Basic");
		assertEquals(1, result.size());
		
		var manyResult = repo.searchForStudent(1);
		assertEquals(0, manyResult.size());
	}
}
