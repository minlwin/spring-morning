package com.jdc.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.spring.controller.advice.ValidationErrorException;
import com.jdc.spring.model.dto.AccountDto;
import com.jdc.spring.model.entity.Account.Role;
import com.jdc.spring.model.form.AccountForm;
import com.jdc.spring.model.form.AccountUpdateForm;
import com.jdc.spring.model.service.AccountService;

@RestController
@RequestMapping("account")
public class AccountApi {
	
	@Autowired
	private AccountService service;

	@GetMapping
	List<AccountDto> search(@RequestParam Optional<Role> role) {
		return service.search(role);
	}
	
	@GetMapping("{id}")
	AccountDto findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@PostMapping
	AccountDto create(@Validated @RequestBody AccountForm form, BindingResult result) {
		
		if(result.hasErrors()) {
			throw new ValidationErrorException(result.getFieldErrors());
		}
		
		return service.create(form);
	}
	
	@PutMapping("{id}")
	AccountDto update(@PathVariable int id, @Validated @RequestBody AccountUpdateForm form, BindingResult result) {
		
		if(result.hasErrors()) {
			throw new ValidationErrorException(result.getFieldErrors());
		}

		return service.update(id, form);
	}
}
