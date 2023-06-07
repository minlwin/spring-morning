package com.jdc.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
			User.builder().username("Admin").password("{noop}Admin").authorities("Admin").build(),
			User.builder().username("Member").password("{noop}Member").authorities("Member").build()
		);
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(auth -> {
			auth.dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll();
			auth.requestMatchers("/").permitAll();
			auth.requestMatchers("/resources/**").permitAll();
			auth.requestMatchers("/admin/**").hasAuthority("Admin");
			auth.requestMatchers("/member/**").hasAnyAuthority("Admin", "Member");
			auth.anyRequest().denyAll();
		});
		
		http.formLogin(Customizer.withDefaults());

		return http.build();
	}
	
}
