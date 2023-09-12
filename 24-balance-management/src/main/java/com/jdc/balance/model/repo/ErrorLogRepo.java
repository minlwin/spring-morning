package com.jdc.balance.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.balance.model.data.entity.ErrorLog;

public interface ErrorLogRepo extends JpaRepositoryImplementation<ErrorLog, Long>{

}
