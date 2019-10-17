package com.poseidonapp.prototipo;

import java.nio.file.Paths;
import java.util.Locale;

import org.hibernate.annotations.common.util.impl.LoggerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MvcConfig implements WebMvcConfigurer{


	@Bean
	public LocaleResolver localResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("es", "ES"));
		return localeResolver;
	}
	
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("Lang");
		return localeChangeInterceptor;
		
		
	}
	
	
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
	/*
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		
	WebMvcConfigurer.super.addResourceHandlers(registry);
		String resourcePath = Paths.get("uploads").toAbsolutePath().toUri().toString();
		registry.addResourceHandler("/uploads/**")
		.addResourceLocations(resourcePath);
	}
*/
}
