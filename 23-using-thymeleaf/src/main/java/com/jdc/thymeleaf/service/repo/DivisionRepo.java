package com.jdc.thymeleaf.service.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.thymeleaf.service.entity.Division;

public interface DivisionRepo extends JpaRepositoryImplementation<Division, Integer>{

}
