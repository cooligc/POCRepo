package com.skc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
/**
 * <p> Spring security configurations </p>
 * @author sitakant
 * */
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.POST,"/employee").hasRole("USER")
												  .antMatchers(HttpMethod.GET,"/employee**").hasRole("USER")
												  .antMatchers(HttpMethod.PUT,"/employee/**").hasRole("USER")
												  .antMatchers(HttpMethod.DELETE,"/employee/**").hasRole("USER")
												  .and().csrf().disable();
	}

	/**
	 * This method will enable the inmemory authentication for the application
	 * */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	}
}
