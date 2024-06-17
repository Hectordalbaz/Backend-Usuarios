package com.usuarios.usuariosBackend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuarios.usuariosBackend.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
	public Usuario findByClave(String clave);

}
