package com.jdc.demo.controller;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.demo.dto.Message;

@RestController
@RequestMapping("hello")
public class HelloApi {
	
	@GetMapping
	Message hello() {
		return new Message("first rest", "Hello Spring MVC");
	}
	
	// GET /hello/generate
	// @RequestMapping(path = "generate", method = RequestMethod.GET)
	@GetMapping("generate/{size}/{message}")
	List<Message> generate(@PathVariable("size") int count, @PathVariable String message) {
		return IntStream.iterate(0, a -> a + 1).limit(count)
				.mapToObj(num -> new Message("Key %d".formatted(num), "%s %d".formatted(message, num)))
				.toList();
	}
	
	@GetMapping("generate")
	List<Message> generateWithRequestParam(@RequestParam int count, @RequestParam String message) {
		return IntStream.iterate(0, a -> a + 1).limit(count)
				.mapToObj(num -> new Message("Key %d".formatted(num), "%s %d".formatted(message, num)))
				.toList();
	}
	
}
