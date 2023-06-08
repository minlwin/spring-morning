package com.jdc.demo.service.security;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jdc.demo.service.repo.MembersRepo;

@Service
public class MemberDetailsService implements UserDetailsService{
	
	@Autowired
	private MembersRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repo.findOneByEmail(username)
				.map(a -> User.withUsername(username)
						.password(a.getPassword())
						.authorities(a.getRole().name())
						.disabled(!a.isActivated())
						.accountLocked(a.isLocked())
						.accountExpired(null != a.getExpired() && a.getExpired().isBefore(LocalDate.now()))
						.build()).orElseThrow();
	}

}
