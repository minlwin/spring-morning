package com.jdc.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jdc.demo.service.entity.Members;
import com.jdc.demo.service.entity.Members.Role;
import com.jdc.demo.service.repo.MembersRepo;

@Service
@Transactional(readOnly = true)
public class MemberService {
	
	@Autowired
	private MembersRepo repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public Members findById(Integer id) {
		return repo.findById(id).orElseThrow();
	}

	@Transactional
	public void save(Members form) {
		
		if(form.getId() == 0) {
			
			if(!StringUtils.hasLength(form.getPassword())) {
				form.setPassword(form.getEmail());
			}
			
			form.setPassword(encoder.encode(form.getPassword()));
		}
		
		repo.save(form);
	}

	public List<Members> search(Optional<Role> role, Optional<String> keyword) {
		return repo.findAll(withRole(role).and(withKeyword(keyword)));
	}
	
	private Specification<Members> withRole(Optional<Role> data) {
		return data.isEmpty() ? Specification.where(null) : 
			(root, query, cb) -> cb.equal(root.get("role"), data.get());
	}

	private Specification<Members> withKeyword(Optional<String> data) {
		return data.isEmpty() ? Specification.where(null) : 
			(root, query, cb) -> cb.or(
					cb.like(cb.lower(root.get("name")), data.get().toLowerCase().concat("%")),
					cb.like(cb.lower(root.get("email")), data.get().toLowerCase().concat("%"))
					);
	}
}
