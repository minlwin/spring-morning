package com.jdc.balance.model.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.balance.model.data.entity.Member;
import com.jdc.balance.model.data.entity.consts.MemberStatus;
import com.jdc.balance.model.data.entity.consts.Role;
import com.jdc.balance.model.data.form.SignUpForm;
import com.jdc.balance.model.data.vo.PageResultVo;
import com.jdc.balance.model.data.vo.admin.MemberListVo;
import com.jdc.balance.model.repo.MemberRepo;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepo memberRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	public void signUp(SignUpForm form) {

		var entity = new Member();
		entity.setName(form.getName());
		entity.setEmail(form.getEmail());
		entity.setPassword(passwordEncoder.encode(form.getPassword()));
		entity.setRole(Role.Member);
		entity.setRegistAt(LocalDate.now());
		entity.setStatus(MemberStatus.Apply);
		
		memberRepo.save(entity);
	}

	public PageResultVo<MemberListVo> search(Optional<Role> role, Optional<String> name, Optional<LocalDate> from, Optional<LocalDate> to,
			int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
