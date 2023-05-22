package com.app.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.web.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	private CustomUserDetailsService userDetailsService;

	@Autowired
	public SecurityConfiguration(CustomUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	/*
	 * Create and return a BCryptPasswordEncoder for encoding passwords
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		// Create and return a BCryptPasswordEncoder for encoding passwords
		return new BCryptPasswordEncoder();
	}

	/*
	 * Configure the AuthenticationManagerBuilder to use the
	 * CustomUserDetailsService for user authentication and the
	 * BCryptPasswordEncoder for password encoding
	 */
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	/*
	 * Configure the HttpSecurity to authorize requests, require authentication for
	 * any request, use a form-based login page at "/login", permit all access to
	 * the login page, redirect to "/todos" upon successful login, and allow logout
	 * from any page
	 */
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
				.defaultSuccessUrl("/todos", true).and().logout().permitAll();
	}

}
