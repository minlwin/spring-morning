package com.jdc.shop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.shop.model.entity.Category;
import com.jdc.shop.model.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryApi {
	
	@Autowired
	private CategoryService service;

	@GetMapping
	List<Category> findAll() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	Category findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	Category create(@Validated @RequestBody Category data, BindingResult result) {
		return service.save(data);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	Category update(@PathVariable int id, @Validated @RequestBody Category data, BindingResult result) {
		return service.save(id, data);
	}
	
}
