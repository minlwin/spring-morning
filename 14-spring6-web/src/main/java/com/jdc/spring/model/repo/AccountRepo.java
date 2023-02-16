package com.jdc.spring.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.spring.model.dto.AccountDto;
import com.jdc.spring.model.entity.Account;

public interface AccountRepo extends JpaRepositoryImplementation<Account, Integer>{

	AccountDto findOneById(int id);

}
