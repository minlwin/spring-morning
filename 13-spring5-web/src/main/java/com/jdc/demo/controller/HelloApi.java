package com.jdc.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.demo.dto.Message;

@RestController
@RequestMapping("hello")
public class HelloApi {

	@GetMapping
	Message hello() {
		return new Message("first rest", "Hello Spring MVC");
	}
}
