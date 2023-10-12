package com.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.api.service.UserDetailsServiceImpl;

/**
 * Aquí configuro las restricciones de acceso
 * 
 * @author dardo
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	/**
	 * Le digo a Spring Security con qué algoritmo encriptar las pass
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
		// No usar NoOpPasswordEncoder en produccion ya que no estamos encriptando
		// password. Usar BCryptPasswordEncoder o algun otro algoritmo
		return NoOpPasswordEncoder.getInstance();
	}

	/**
	 * Restringe acceso a recursos
	 * 
	 * @param http
	 * @return configuracion de acceso
	 * @throws Exception
	 */
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests((requests) -> requests
				// para este recurso debe ser administrador
				.requestMatchers("/clima/**", "/evento/**", "/pronostico/**").hasAuthority("ADMIN")
				.requestMatchers("/usuario/**").hasAuthority("USER") // para este solo User
				.anyRequest().denyAll()) // deniego todo el resto
				.httpBasic();
		return http.build();
	}

}
