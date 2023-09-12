package com.jdc.balance.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.balance.model.data.entity.AccessLog;

public interface AccessLogRepo extends JpaRepositoryImplementation<AccessLog, Long>{

}
