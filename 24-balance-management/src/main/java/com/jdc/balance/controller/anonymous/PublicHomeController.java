package com.jdc.balance.controller.anonymous;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.balance.model.data.entity.consts.Role;

@Controller
@RequestMapping("public/home")
public class PublicHomeController {

	@GetMapping
	public String index() {
		
		var authentication = SecurityContextHolder.getContext().getAuthentication();
		var home = authentication.getAuthorities().stream()
				.map(a -> a.getAuthority().equals(Role.Admin.name()) ? "admin" : "member")
			.map(a -> "redirect:/%s/home".formatted(a)).findAny().orElse(null);
		
		if(null != home) {
			return home;
		}
		
		return "views/anonymous/home";
	}

}