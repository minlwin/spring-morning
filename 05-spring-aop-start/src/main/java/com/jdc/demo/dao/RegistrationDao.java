package com.jdc.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.jdc.demo.controller.BaseDao;
import com.jdc.demo.dao.dto.Registration;

@Repository
@Qualifier("registration")
public class RegistrationDao implements BaseDao<Registration>{

	@Override
	public int create(Registration data) {
		System.out.println("Create %s".formatted(data));
		return 1;
	}

	@Override
	public void update(int id, Registration data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Registration findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Registration> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
