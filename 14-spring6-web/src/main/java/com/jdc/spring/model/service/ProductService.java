package com.jdc.spring.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jdc.spring.model.dto.ProductDto;
import com.jdc.spring.model.entity.Product;
import com.jdc.spring.model.form.ProductForm;
import com.jdc.spring.model.repo.CategoryRepo;
import com.jdc.spring.model.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private CategoryRepo categoryRepo;

	@Transactional(readOnly = true)
	public List<ProductDto> search(Optional<Integer> category, Optional<String> name) {
		return productRepo.findBy(whichCategory(category).and(whichName(name)), 
				query -> query.as(ProductDto.class).all());
	}
	
	private Specification<Product> whichCategory(Optional<Integer> category) {
		return category.filter(id -> id != 0).isEmpty() ? Specification.where(null) :
			(root, query, cb) -> cb.equal(root.get("category").get("id"), category.get());
	}
	
	private Specification<Product> whichName(Optional<String> name) {
		return name.filter(a -> StringUtils.hasLength(a)).isEmpty() ? Specification.where(null)
				: (root, query, cb) -> cb.like(cb.lower(root.get("name")), name.get().toLowerCase().concat("%"));
	}
	

	@Transactional(readOnly = true)
	public ProductDto findById(int id) {
		return productRepo.findOneById(id);
	}

	@Transactional
	public ProductDto create(ProductForm form) {
		
		var category = categoryRepo.findById(form.categoryId()).orElseThrow();
		var product = new Product();
		product.setCategory(category);
		product.setName(form.name());
		product.setPhoto(form.photo());
		product.setPrice(form.price());
		
		product = productRepo.save(product);
		
		return productRepo.findOneById(product.getId());
	}

	@Transactional
	public ProductDto update(int id, ProductForm form) {
		
		var product = productRepo.findById(id).orElseThrow();
		product.setName(form.name());
		product.setPhoto(form.photo());
		product.setPrice(form.price());
		
		if(product.getCategory().getId() != form.categoryId()) {
			product.setCategory(categoryRepo.findById(form.categoryId()).orElseThrow());
		}
		
		productRepo.save(product);
		
		return productRepo.findOneById(id);
	}

}
