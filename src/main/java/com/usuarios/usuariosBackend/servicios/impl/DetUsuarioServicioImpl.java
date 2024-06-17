package com.usuarios.usuariosBackend.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.usuarios.usuariosBackend.modelo.Usuario;
import com.usuarios.usuariosBackend.repositorio.UsuarioRepositorio;

@Service
public class DetUsuarioServicioImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepositorio repositorio;

	@Override
	public UserDetails loadUserByUsername(String clave) throws UsernameNotFoundException {
		Usuario usuario=this.repositorio.findByClave(clave);
		if(usuario==null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		return usuario;
	}

}
