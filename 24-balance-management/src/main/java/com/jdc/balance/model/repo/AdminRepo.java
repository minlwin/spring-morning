package com.jdc.balance.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.balance.model.data.entity.Admin;

public interface AdminRepo extends JpaRepositoryImplementation<Admin, Long>{

}
