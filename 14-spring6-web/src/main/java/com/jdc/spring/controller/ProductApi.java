package com.jdc.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.spring.model.dto.ProductDto;
import com.jdc.spring.model.form.ProductForm;
import com.jdc.spring.model.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductApi {
	
	@Autowired
	private ProductService service;

	@GetMapping
	List<ProductDto> search(
			@RequestParam Optional<Integer> category, 
			@RequestParam Optional<String> name) {
		return service.search(category, name);
	}
	
	@GetMapping("{id}")
	ProductDto findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@PostMapping
	ProductDto create(@RequestBody ProductForm form) {
		return service.create(form);
	}
	
	@PutMapping("{id}")
	ProductDto update(@PathVariable int id, @RequestBody ProductForm form) {
		return service.update(id, form);
	}
}
