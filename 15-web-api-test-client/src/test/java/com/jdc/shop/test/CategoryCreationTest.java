package com.jdc.shop.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.web.context.WebApplicationContext;

import com.jdc.shop.ShopAppWebConfig;
import com.jdc.shop.model.dto.Message;
import com.jdc.shop.model.dto.Message.Status;
import com.jdc.shop.model.entity.Category;

@SpringJUnitWebConfig(classes = ShopAppWebConfig.class)
@Sql(statements = {
		"truncate table category restart identity"	
	})
public class CategoryCreationTest {

	private WebTestClient client;
	
	@BeforeEach
	void setUp(WebApplicationContext context) {
		client = MockMvcWebTestClient.bindToApplicationContext(context).build();
	}
	
	@ParameterizedTest
	@ValueSource(strings = {
			"Foods", "Drinks", "Fashions"
	})
	void test_create(String name) {
		
		var input = new Category();
		input.setName(name);
		
		var result = client.post().uri("/category")
			.bodyValue(input)
			.exchange()
			.expectStatus().isCreated()
			.expectBody(Category.class)
			.returnResult().getResponseBody();
			
		assertThat(result, allOf(
				notNullValue(),
				hasProperty("id", is(1)),
				hasProperty("name", is(name))
				));
	}
	
	@Test
	void test_create_error() {
		var input = new Category();
		
		var result = client.post().uri("/category")
			.bodyValue(input)
			.exchange()
			.expectStatus().isBadRequest()
			.expectBody(Message.class)
			.returnResult().getResponseBody();
		
		assertThat(result, allOf(
				notNullValue(),
				hasProperty("status", is(Status.Validation)),
				hasProperty("messages", contains("Please enter category name."))
				));
	}
	
	@ParameterizedTest
	@Sql(statements = {
			"truncate table category restart identity",
			"insert into category(name) values ('Foods')",
			"insert into category(name) values ('Drinks')",
		})
	@CsvSource({
		"1,Fashions",
		"2,Jeans"
	})
	void test_update(int id, String name) {
		var input = new Category();
		input.setName(name);
		
		var result = client.put().uri("/category/%d".formatted(id))
			.bodyValue(input)
			.exchange()
			.expectStatus().isAccepted()
			.expectBody(Category.class)
			.returnResult().getResponseBody();
		
		assertThat(result, allOf(
				notNullValue(),
				hasProperty("id", is(id)),
				hasProperty("name", is(name))
				));
		
	}
}
