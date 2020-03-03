package com.poseidonapp.prototipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.poseidonapp.prototipo.auth.handler.LoginSuccesHandler;
import com.poseidonapp.prototipo.service.UsuarioService;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private LoginSuccesHandler succesHandler;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/", "/css/**","/contacto/","/aboutus/", "/js/**", "/img/**", "/uploads/**", 
					"/webjars/**","/categoria/","/producto/","/categoria/listcategoria/{id}","/producto/ver/{id}","/producto/uploads/**","/usuario/**").permitAll()
			
			//.antMatchers("/categoria/**").hasAnyRole("ADMIN")
			//.antMatchers("/producto/**").hasAnyRole("ADMIN")
			
			.anyRequest().authenticated()
			.and()
				.formLogin()
					.successHandler(succesHandler)
					.loginPage("/login")
				.permitAll()
			.and()
				.logout().permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/error_403");
		
	}



	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
		
			builder.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);
	}
	
}
