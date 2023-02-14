package com.jdc.spring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloApi {

	@GetMapping
	List<String> index() {
		return List.of("Hello Spring MVC 6", "Java Based Config");
	}
}
