package com.jdc.balance.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jdc.balance.model.data.entity.consts.MemberStatus;
import com.jdc.balance.model.repo.AccountRepo;

@Service
public class ApplicationUserDetailsService implements UserDetailsService{
	
	@Autowired
	private AccountRepo accountRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return accountRepo.findOneByEmail(username).map(a -> User.withUsername(username)
				.password(a.getPassword())
				.authorities(a.getRole().name())
				.disabled(a.getStatus() == MemberStatus.Apply)
				.accountLocked(a.getStatus() == MemberStatus.Denied)
				.accountExpired(a.getAudit().isDeleted() || a.getStatus() == MemberStatus.Deleted)
				.build()).orElseThrow(() -> new UsernameNotFoundException(username));
	}

}
