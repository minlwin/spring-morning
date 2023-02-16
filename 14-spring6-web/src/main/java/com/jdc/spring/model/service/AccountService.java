package com.jdc.spring.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.model.dto.AccountDto;
import com.jdc.spring.model.entity.Account.Role;
import com.jdc.spring.model.form.AccountForm;
import com.jdc.spring.model.repo.AccountRepo;

@Service
@Transactional(readOnly = true)
public class AccountService {
	
	@Autowired
	private AccountRepo repo;

	public List<AccountDto> search(Optional<Role> role) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountDto findById(int id) {
		return repo.findOneById(id);
	}

	@Transactional
	public AccountDto create(AccountForm form) {
		var entity = repo.save(form.entity());
		return repo.findOneById(entity.getId());
	}

	@Transactional
	public AccountDto update(int id, AccountForm form) {
		var entity = form.entity();
		entity.setId(id);
		repo.save(entity);
		return repo.findOneById(id);
	}

}
