package com.jdc.demo.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jdc.demo.controller.BaseDao;
import com.jdc.demo.dao.dto.Account;
import com.jdc.demo.dao.dto.Classes;
import com.jdc.demo.dao.dto.Registration;

@Service
public class RegistrationService {

	@Autowired
	@Qualifier("account")
	private BaseDao<Account> accountDao;
	@Autowired
	@Qualifier("classes")
	private BaseDao<Classes> classesDao;
	@Autowired
	@Qualifier("registration")
	private BaseDao<Registration> registrationDao;
	
	public Registration register(Account account, int classesId, LocalDate date) {
		// Create Student
		var studentId = accountDao.create(account);
		
		// Find Class
		var classes = classesDao.findById(classesId);
		
		var registration = new Registration(0, classes, account.withId(studentId), date);
		var registrationId = registrationDao.create(registration);
		
		return registration.withId(registrationId);
	}
}
