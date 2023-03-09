package com.jdc.shop.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.web.context.WebApplicationContext;

import com.jdc.shop.ShopAppWebConfig;
import com.jdc.shop.model.entity.Category;

@SpringJUnitWebConfig(classes = ShopAppWebConfig.class)
public class CategoryApiTest {

	private WebTestClient testClient;
	
	@BeforeEach
	void setUp(WebApplicationContext context) {
		testClient = MockMvcWebTestClient
				.bindToApplicationContext(context).build();
	}
	
	@Test
	@Sql(statements = {
		"insert into category(name) values ('Foods')",
		"insert into category(name) values ('Drinks')",
	})
	void find_all() {
		var result = testClient.get().uri("/category")
				.exchange()
				.expectStatus().isOk()
				.expectBody(Category[].class)
				.returnResult().getResponseBody();
		
		for(var c : result) {
			System.out.println(c);
		}
	}
}
