package com.jdc.balance;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jdc.balance.model.data.entity.Admin;
import com.jdc.balance.model.data.entity.consts.MemberStatus;
import com.jdc.balance.model.repo.AccountRepo;

@Configuration
public class AdminUserInitiliazer {

	@Autowired
	private AccountRepo repo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@EventListener(value = ContextRefreshedEvent.class)
	void initAdmin() {
		if(repo.count() == 0) {
			var admin = new Admin();
			admin.setName("Min Lwin");
			admin.setEmail("minlwin@gmail.com");
			admin.setPassword(passwordEncoder.encode("minlwin"));
			admin.setRegistAt(LocalDate.now());
			admin.setStatus(MemberStatus.Approved);
			repo.save(admin);
		}
	}
}
