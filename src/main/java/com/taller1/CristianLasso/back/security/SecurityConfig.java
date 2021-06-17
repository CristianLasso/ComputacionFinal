package com.taller1.CristianLasso.back.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoggingAccessDeniedHandler accessDeniedHandler;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().antMatchers("/user/login**").permitAll().antMatchers("/user/autotransition/**", "/user/fevInstitution/**")
				.hasRole("admin").antMatchers("/user/localcondition/**", "/user/precondition/**", "/user/threshold/**", "/user/fevInstitution/**")
				.hasAnyRole("operator").anyRequest().authenticated().and().formLogin().loginPage("/user/login").permitAll()
				.and().logout().invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")).logoutSuccessUrl("/user/login?logout")
				.permitAll().and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);

		
	}
}