package com.jdc.spring.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.model.dto.AccountDto;
import com.jdc.spring.model.entity.Account;
import com.jdc.spring.model.entity.Account.Role;
import com.jdc.spring.model.form.AccountForm;
import com.jdc.spring.model.form.AccountUpdateForm;
import com.jdc.spring.model.repo.AccountRepo;

@Service
@Transactional(readOnly = true)
public class AccountService {
	
	@Autowired
	private AccountRepo repo;

	public List<AccountDto> search(Optional<Role> role) {
		
		Specification<Account> predicate = role.isEmpty() ? 
				Specification.where(null) : 
				(root, query, cb) -> cb.equal(root.get("role"), role.get());
		
		return repo.findBy(predicate, query -> query.as(AccountDto.class).all());
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
	public AccountDto update(int id, AccountUpdateForm form) {
		
		var entity = repo.findById(id).orElseThrow();
		entity.setEmail(form.email());
		entity.setRole(form.role());
		entity.setName(form.name());
		
		repo.save(entity);
		
		return repo.findOneById(id);
	}

}
