package com.jdc.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.thymeleaf.service.entity.Division;
import com.jdc.thymeleaf.service.repo.DivisionRepo;

@Service
@Transactional(readOnly = true)
public class DivisionService {

	@Autowired
	private DivisionRepo repo;
	
	public List<Division> findAll() {
		return repo.findAll();
	}
}
