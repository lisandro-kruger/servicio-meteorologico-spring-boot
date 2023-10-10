package com.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.api.dao.UsuarioRepository;

/**
 * Servicio utilizado por Spring Security para obtener el usuario que está
 * requiriendo acceder a nuestros recursos. Luego con ese usuario chequeaá si
 * está autenticado y si está autorizado
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		return usuarioRepository.findByUsername(username);

	}

}