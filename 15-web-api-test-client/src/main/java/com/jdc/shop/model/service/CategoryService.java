package com.jdc.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.shop.model.entity.Category;
import com.jdc.shop.model.repo.CategoryRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional(readOnly = true)
public class CategoryService {

	@Autowired
	private CategoryRepo repo;

	public List<Category> findAll() {
		return repo.findAll();
	}

	public Category findById(int id) {
		return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no category with id %d.".formatted(id)));
	}
	
	@Transactional
	public Category save(Category data) {
		return repo.save(data);
	}

}
