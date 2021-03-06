/**
 * 
 */
package com.pritamprasad.spring_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Pritam
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication().withUser("pritam").password("jarvis").roles("ADMIN");
	auth.inMemoryAuthentication().withUser("pritamprasad").password("123456").roles("USER");
	auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
	auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers("/index/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')").and().formLogin();
	//http.authorizeRequests().antMatchers("/index").hasIpAddress("::1");
	//http.authorizeRequests().anyRequest();
    }
}
