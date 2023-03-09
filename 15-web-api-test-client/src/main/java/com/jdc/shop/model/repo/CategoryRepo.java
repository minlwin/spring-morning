package com.jdc.shop.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.shop.model.entity.Category;

public interface CategoryRepo extends JpaRepositoryImplementation<Category, Integer>{

}
