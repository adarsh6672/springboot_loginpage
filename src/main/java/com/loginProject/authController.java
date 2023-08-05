package com.loginProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class authController {
	
	
	@GetMapping("/")
	public String home() {
		return "login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
