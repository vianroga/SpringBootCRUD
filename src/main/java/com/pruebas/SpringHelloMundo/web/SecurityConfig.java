/**
 * Creado por: Victor Roman Garrido
 * Fecha:9/09/2021 7:06:20 p. m.
 */
package com.pruebas.SpringHelloMundo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Victor Roman Garrido
 *
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configurerGlobal (AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//Autorizacion
		http.authorizeRequests()
		.antMatchers("/editar/**","/agregar/**","/eliminar")
		.hasRole("ADMIN")
		.antMatchers("/")
		.hasAnyRole("USER","ADMIN")
		.and()
		.formLogin()
		.loginPage("/login")
		.and()
		.exceptionHandling().accessDeniedPage("/errores/403");
	}
}
