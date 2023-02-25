package com.akashSpringLearning.springpractice.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class CustomSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
		.withUser("user")
		.password("Jan@2023@@")
		.roles("USER")
		.and()
		.withUser("akadari")
		.password("Jan!2023!!")
		.roles("ADMIN")
		.and()
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.mvcMatchers("/api/v1/home").authenticated()
		.mvcMatchers("/api/v1/user").hasRole("USER")
		.mvcMatchers("/api/v1/Admin").hasRole("ADMIN")
		.mvcMatchers("/home").permitAll()
		.and().formLogin()
//		.loginPage("/login");
		.defaultSuccessUrl("/api/v1/user").failureUrl("/login?error=true").permitAll()
		.and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
////		
		.and().httpBasic();
//		
//		
	}

}
