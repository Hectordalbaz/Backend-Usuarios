package com.usuarios.usuariosBackend.servicios;

import org.springframework.stereotype.Service;

import com.usuarios.usuariosBackend.modelo.Usuario;

@Service
public interface UsuarioServicio {
public Usuario regUsuario(Usuario usuario) throws Exception;
}
