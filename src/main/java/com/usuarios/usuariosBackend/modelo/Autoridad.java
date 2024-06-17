package com.usuarios.usuariosBackend.modelo;

import org.springframework.security.core.GrantedAuthority;

public class Autoridad implements GrantedAuthority{
	
	private String autoridad;
	
	public Autoridad(String autoridad) {
		this.autoridad=autoridad;
	}

	@Override
	public String getAuthority() {
		return this.autoridad;
	}

}
