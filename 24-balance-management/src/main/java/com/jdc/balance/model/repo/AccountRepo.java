package com.jdc.balance.model.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.balance.model.data.entity.Account;

public interface AccountRepo extends JpaRepositoryImplementation<Account, Long>{

	Optional<Account> findOneByEmail(String email);
}
