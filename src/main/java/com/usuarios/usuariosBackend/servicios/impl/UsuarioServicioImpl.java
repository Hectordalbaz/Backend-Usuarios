package com.usuarios.usuariosBackend.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuarios.usuariosBackend.modelo.Usuario;
import com.usuarios.usuariosBackend.repositorio.UsuarioRepositorio;
import com.usuarios.usuariosBackend.servicios.UsuarioServicio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
	@Autowired
	private UsuarioRepositorio repositorio;
	
	@Override 
	public Usuario regUsuario(Usuario usuario) throws Exception {
		Usuario usuarioLocal= repositorio.findByClave(usuario.getClave());
		if(usuarioLocal!=null) {
			System.out.println("Ya esta registrado un usuario con esa clave");
			throw new Exception("El usuario ya esta registrado");
		}else {
			usuarioLocal=repositorio.save(usuario);
		}
		return usuarioLocal;
	}
}
