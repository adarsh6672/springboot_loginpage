package com.loginProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.authorizeRequests(authorize ->
						authorize
								.requestMatchers("/", "/login").permitAll()
								.requestMatchers("/hello").authenticated()
				)
				.formLogin(form ->
						form
								.loginPage("/login")
								.loginProcessingUrl("/login")
								.defaultSuccessUrl("/hello")
								.permitAll()
				)
				.logout()
				.logoutSuccessUrl("/login?logout")
				.deleteCookies("JSESSIONID");

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		UserDetails user = User.withUsername("adarsh")
				.password(encoder.encode("1234"))
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);


	}



	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}