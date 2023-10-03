package com.jdc.balance.model.service;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AppAuditorAwareBean implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
				.filter(a -> !(a instanceof AnonymousAuthenticationToken))
				.filter(a -> a.isAuthenticated())
				.map(a -> a.getName())
				.or(() -> Optional.of("System"));
	}

}
