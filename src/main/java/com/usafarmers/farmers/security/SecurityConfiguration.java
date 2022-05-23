package com.usafarmers.farmers.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

        http

        /* Login configuration */
        .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/index") // user's home page, it can be any URL
        .permitAll() // Anyone can go to the login page
        /* Logout configuration */
        .and()
        .logout()
        .logoutSuccessUrl("/index") // append a query string value
        /* Pages that can be viewed without having to log in */
        .and()
        .authorizeRequests()
        .antMatchers("/", "/register", "/users/exists", "/login",
        			"/index","/nutrients", "/nutrients/postnutrient/{name}", "/error")
        .permitAll()
        /* Pages that require authentication */
        .and()
        .authorizeRequests()
        .antMatchers("/adminpanel","/adminpanel/{userId}").hasAnyRole("ADMIN")
        .antMatchers("/profile", "/profile/{userId}", 
        				"/discussionform","/discussionform/{messageId}","/createmessage",
        			 "/message/{messageId}/delete","/message/{messageId}/comment/{commentId}delete", 
        			 "/discussionform/createcomment/{messageId}", "/calculator", "/calculate/{cropKey}/{yieldGoal}")
        .authenticated();
}

}
