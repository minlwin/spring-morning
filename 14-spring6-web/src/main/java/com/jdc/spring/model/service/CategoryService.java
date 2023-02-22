package com.jdc.spring.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
		return repo.findBy(whichName(name), query -> query.as(CategoryDto.class).all());
	}
	
	private Specification<Category> whichName(Optional<String> name) {
		return name.filter(a -> StringUtils.hasLength(a)).isEmpty() ? Specification.where(null) : 
			(root, query, cb) -> cb.like(cb.lower(root.get("name")), name.get().toLowerCase().concat("%"));
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
		repo.save(entity);
		return repo.findOneById(id);
	}

}
