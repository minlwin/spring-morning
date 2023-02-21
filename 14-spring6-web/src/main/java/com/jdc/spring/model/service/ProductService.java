package com.jdc.spring.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.spring.model.dto.ProductDto;
import com.jdc.spring.model.form.ProductForm;
import com.jdc.spring.model.repo.CategoryRepo;
import com.jdc.spring.model.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private CategoryRepo categoryRepo;

	public List<ProductDto> search(Optional<Integer> category, Optional<String> name) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductDto findById(int id) {
		return null;
	}

	public ProductDto create(ProductForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductDto update(int id, ProductForm form) {
		// TODO Auto-generated method stub
		return null;
	}

}
