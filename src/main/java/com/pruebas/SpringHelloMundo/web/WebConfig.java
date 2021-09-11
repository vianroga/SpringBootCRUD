/**
 * Creado por: Victor Roman Garrido
 * Fecha:9/09/2021 5:43:08 p. m.
 */
package com.pruebas.SpringHelloMundo.web;


import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * @author Victor Roman Garrido
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Bean
	public LocaleResolver localeResolver() {
		var slr = new SessionLocaleResolver();
		slr.setDefaultLocale(new Locale("es"));
		return slr;	
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		var lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}
	public WebConfig() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void addInterceptors (InterceptorRegistry registro) {
	registro.addInterceptor( localeChangeInterceptor());
	} 
	
	@Override
	public void addViewControllers(ViewControllerRegistry registro) {
		registro.addViewController("/").setViewName("index");
		registro.addViewController("/login");
		registro.addViewController("/errores/403").setViewName("/errores/403");
	}

}
