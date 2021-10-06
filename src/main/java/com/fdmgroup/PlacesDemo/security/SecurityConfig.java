package com.fdmgroup.PlacesDemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/js/**", "/h2/**", "WEB-INF/jsps/**", "/", "/**/*.png").permitAll()
				.antMatchers("/details/**").hasRole("Admin").anyRequest().authenticated()
				.and().formLogin().loginPage("/login").permitAll();
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider (UserDetailsService service) {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(service);
		authProvider.setPasswordEncoder(encoder());

		return authProvider;
	}
	
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
}
