package com.jdc.shop.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.web.context.WebApplicationContext;

import com.jdc.shop.ShopAppWebConfig;
import com.jdc.shop.model.dto.Message;
import com.jdc.shop.model.dto.Message.Status;
import com.jdc.shop.model.entity.Category;

@TestMethodOrder(value = OrderAnnotation.class)
@SpringJUnitWebConfig(classes = ShopAppWebConfig.class)
public class CategoryApiTest {

	private WebTestClient testClient;
	
	@BeforeEach
	void setUp(WebApplicationContext context) {
		testClient = MockMvcWebTestClient
				.bindToApplicationContext(context).build();
	}
	
	@Order(1)
	@Test
	@Sql(statements = {
		"truncate table category restart identity",
		"insert into category(name) values ('Foods')",
		"insert into category(name) values ('Drinks')",
	})
	void find_all() {
		var result = testClient.get().uri("/category")
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(Category.class)
				.returnResult().getResponseBody();
		
		assertThat(result, hasSize(2));	
	}
	
	@Order(2)
	@ParameterizedTest
	@Sql(statements = {
			"truncate table category restart identity",
			"insert into category(name) values ('Foods')",
			"insert into category(name) values ('Drinks')",
		})
	@CsvSource({
		"1,Foods",
		"2,Drinks"
	})
	void find_by_id(int id, String name) {
		var result = testClient.get().uri("/category/%d".formatted(id))
				.exchange()
				.expectStatus().isOk()
				.expectBody(Category.class)
				.returnResult().getResponseBody();
		
		assertThat(result, allOf(
				notNullValue(),
				hasProperty("id", is(id)),
				hasProperty("name", is(name))
		));
	}
	
	@Order(3)
	@ParameterizedTest
	@Sql(statements = {
			"truncate table category restart identity",
			"insert into category(name) values ('Foods')",
			"insert into category(name) values ('Drinks')",
		})
	@ValueSource(ints = {3, 4})
	void find_by_id_not_found(int id) {
		var result = testClient.get().uri("/category/%d".formatted(id))
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectBody(Message.class)
				.returnResult().getResponseBody();
		
		assertThat(result, allOf(
				notNullValue(),
				hasProperty("status", is(Status.Business)),
				hasProperty("message", is("There is no category with id %d.".formatted(id)))
				));
	}
}
