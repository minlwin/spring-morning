package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.dto.Member;
import com.jdc.demo.service.MemberService;

@SpringJUnitConfig(locations = "classpath:/application.xml")
public class MemberServiceTest {
	
	@Autowired
	private MemberService service;
	
	@ParameterizedTest
	@CsvSource({
		"minlwin,Min Lwin,09782003098,lwin.zawmin@gmail.com,1"
	})
	void testSuccess(String login, String name, String phone, String email, int expected) {
		var input = new Member(login, name, phone, email);
		var result = service.create(input);
		assertEquals(expected, result);
	}

	@ParameterizedTest
	@CsvSource({
		"minlwin,,09782003098,lwin.zawmin@gmail.com"
	})
	void testError(String login, String name, String phone, String email) {
		var input = new Member(login, name, phone, email);

		assertThrows(RuntimeException.class, () -> service.create(input));
	}
}
