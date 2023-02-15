package com.jdc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.demo.model.entity.Member;
import com.jdc.demo.model.repo.MemberRepo;

@RestController
@RequestMapping("member")
public class MemberApi {

	@Autowired
	private MemberRepo repo;
	
	@GetMapping
	List<Member> index() {
		return repo.findAll();
	}
	
	// URL : /member/{id}
	@GetMapping("{id}")
	Member findById(@PathVariable int id) {
		return repo.findById(id).orElseThrow();
	}
	
	@Transactional
	@PostMapping
	Member create(@RequestBody Member member) {
		return repo.save(member);
	}
	
	@Transactional
	@PutMapping("{id}")
	Member update(@PathVariable int id, @RequestBody Member member) {
		var dbData = repo.findById(id).orElseThrow();
		dbData.setEmail(member.getEmail());
		dbData.setName(member.getName());
		dbData.setRole(member.getRole());
		dbData.setPassword(member.getPassword());
		return repo.findById(id).get();
	}
}
