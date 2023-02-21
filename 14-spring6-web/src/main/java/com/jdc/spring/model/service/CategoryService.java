package com.jdc.spring.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.model.dto.CategoryDto;
import com.jdc.spring.model.entity.Category;
import com.jdc.spring.model.form.CategoryForm;
import com.jdc.spring.model.repo.CategoryRepo;

@Service
@Transactional(readOnly = true)
public class CategoryService {
	
	@Autowired
	private CategoryRepo repo;

	public List<CategoryDto> search(Optional<String> name) {
		// TODO Auto-generated method stub
		return null;
	}

	public CategoryDto findById(int id) {
		return repo.findOneById(id);
	}

	@Transactional
	public CategoryDto create(CategoryForm form) {
		var category = new Category();
		category.setName(form.name());
		category = repo.save(category);
		return repo.findOneById(category.getId());
	}

	@Transactional
	public CategoryDto update(int id, CategoryForm form) {
		var entity = repo.findById(id).orElseThrow();
		entity.setName(form.name());
		return repo.findOneById(id);
	}

}
