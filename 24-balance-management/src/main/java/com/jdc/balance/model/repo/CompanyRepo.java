package com.jdc.balance.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.balance.model.data.entity.Company;

public interface CompanyRepo extends JpaRepositoryImplementation<Company, Long>{

}
