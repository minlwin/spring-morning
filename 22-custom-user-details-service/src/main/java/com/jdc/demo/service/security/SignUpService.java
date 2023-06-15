package com.jdc.demo.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.controller.form.SignUpForm;
import com.jdc.demo.service.MemberService;
import com.jdc.demo.service.entity.Members;
import com.jdc.demo.service.entity.Members.Role;

@Service
public class SignUpService {
	
	@Autowired
	private MemberService memberService;
	
	@Transactional
	public void signUp(SignUpForm form) {
		
		var entity = new Members();
		entity.setEmail(form.getEmail());
		entity.setName(form.getName());
		entity.setPassword(form.getPassword());
		entity.setActivated(true);
		entity.setRole(Role.Customer);
		
		memberService.save(entity);
	}

	
}
