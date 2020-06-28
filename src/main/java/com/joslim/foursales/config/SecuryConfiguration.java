package com.joslim.foursales.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecuryConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		//Para fins de teste, caso queira listar candidatos, trocar o DELETE por GET
		httpSecurity.authorizeRequests().antMatchers(HttpMethod.DELETE, "/candidatos/*").permitAll().anyRequest()
				.fullyAuthenticated().and().httpBasic();
		httpSecurity.csrf().disable();

	}



}
