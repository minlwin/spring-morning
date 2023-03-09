package com.jdc.shop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
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
import com.jdc.shop.model.repo.CategoryRepo;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("category")
public class CategoryApi {
	
	@Autowired
	private CategoryRepo repo;

	@GetMapping
	List<Category> findAll() {
		return repo.findAll();
	}
	
	@GetMapping("{id}")
	Category findById(@PathVariable int id) {
		return repo.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Transactional
	Category create(@Validated @RequestBody Category data, BindingResult result) {
		return repo.save(data);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@Transactional
	Category update(@PathVariable int id, @Validated @RequestBody Category data, BindingResult result) {
		var entity = repo.findById(id).orElseThrow(EntityNotFoundException::new);
		entity.setName(data.getName());
		return entity;
	}
	
}
