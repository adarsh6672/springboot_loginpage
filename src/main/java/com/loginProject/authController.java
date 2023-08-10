package com.loginProject;

import ch.qos.logback.core.model.Model;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class authController {
	
	
	@GetMapping("/")
	public String home() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}

		return "redirect:/hello";
	}
	
	@GetMapping("/login")
	public String login(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}

		return "redirect:/hello";
	}

//	public String login() {
//		return "login";
//	}
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
