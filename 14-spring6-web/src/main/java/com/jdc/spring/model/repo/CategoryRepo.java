package com.jdc.spring.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.spring.model.dto.CategoryDto;
import com.jdc.spring.model.entity.Category;

public interface CategoryRepo extends JpaRepositoryImplementation<Category, Integer>{

	CategoryDto findOneById(int id);

}
