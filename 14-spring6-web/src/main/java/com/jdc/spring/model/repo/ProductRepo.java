package com.jdc.spring.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.spring.model.entity.Product;

public interface ProductRepo extends JpaRepositoryImplementation<Product, Integer>{

}
