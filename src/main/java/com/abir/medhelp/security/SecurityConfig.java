package com.abir.medhelp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		auth.inMemoryAuthentication().withUser("user").password(encoder.encode("123")).roles("USER").and()
				.withUser("admin").password(encoder.encode("admin")).roles("USER", "ADMIN");
	}
	
	 @Override
     public void configure(WebSecurity web) throws Exception {
       web
         .ignoring()
            .antMatchers ("/static/**"); 
     }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf ().disable ()
		.authorizeRequests()
		.antMatchers ("/login").permitAll ()
		
		.anyRequest().authenticated()
		.and()
		
		.formLogin ()
        .loginPage ("/login")
        .successHandler (authsuccesshandler ())
        .failureHandler (authfailurehandler ())
        .usernameParameter ("userName")
        .passwordParameter ("password")
        .and ()
        
        .logout ()
        .logoutSuccessUrl ("/login?logout")
        .and ()
        
        .httpBasic();
	}
	
	@Bean
    public AuthenticationSuccessHandler authsuccesshandler() {
      return new CustomAuthSuccessHandler ();
    }

	@Bean
    public AuthenticationFailureHandler authfailurehandler() {
      return new CustomAuthFailureHandler ();
    }
}
