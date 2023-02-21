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

import com.jdc.spring.model.dto.CategoryDto;
import com.jdc.spring.model.form.CategoryForm;
import com.jdc.spring.model.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryApi {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	List<CategoryDto> search(@RequestParam Optional<String> name) {
		return service.search(name);
	}
	
	@GetMapping("{id}")
	CategoryDto findById(@PathVariable int id) {
		return service.findById(id);
	}

	@PostMapping
	CategoryDto create(@RequestBody CategoryForm form) {
		return service.create(form);
	}
	
	@PutMapping("{id}")
	CategoryDto update(@PathVariable int id, @RequestBody CategoryForm form) {
		return service.update(id, form);
	}
	
}
