package com.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	  @Bean
	    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	  
	  @Bean
	    public UserDetailsService users() {
	        UserDetails user1 = User.builder()
	                .username("sema1")
	                .password(bCryptPasswordEncoder().encode("pass"))
	                .roles("USER")
	                .build();
	        UserDetails admin = User.builder()
	                .username("semaAdmin")
	                .password(bCryptPasswordEncoder().encode("pass"))
	                .roles("ADMIN")
	                .build();

	        return new InMemoryUserDetailsManager(user1, admin);
	    }
	  
	  
	
}
