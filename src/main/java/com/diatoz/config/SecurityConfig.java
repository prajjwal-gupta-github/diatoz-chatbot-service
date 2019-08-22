package com.diatoz.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{


	@Value("${ip_address}")
	private String ip_address;
	

	


	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http
		.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/api/bot").hasIpAddress(ip_address)
		.and()
		.csrf().disable().formLogin().disable();
	}
}
