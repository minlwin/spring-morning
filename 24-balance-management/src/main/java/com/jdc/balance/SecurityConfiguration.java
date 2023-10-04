package com.jdc.balance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.jdc.balance.model.repo.base.BaseRepositoryImpl;

@Configuration
@EnableJpaAuditing
@EnableMethodSecurity
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class SecurityConfiguration {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain http(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(config -> {
			config.requestMatchers(
					"/", "/images/**", "/styles/**", "/js/**", "/public/**").permitAll();
			
			config.requestMatchers("/member/**")
				.hasAnyAuthority("Member", "Employee", "Manager", "Company");
			
			config.requestMatchers("/employee/**")
				.hasAnyAuthority("Employee", "Manager", "Company");
			
			config.requestMatchers("/manager/**")
				.hasAnyAuthority("Manager", "Company");
			
			config.requestMatchers("/admin/**").hasAuthority("Admin");
		});
		
		http.formLogin(config -> {
			config.loginPage("/public/signin");
			config.usernameParameter("email");
			config.passwordParameter("pass");
		});
		
		http.logout(config -> {
			config.logoutUrl("/signout");
			config.logoutSuccessUrl("/public/home");
		});
		
		return http.build();
	}
}
