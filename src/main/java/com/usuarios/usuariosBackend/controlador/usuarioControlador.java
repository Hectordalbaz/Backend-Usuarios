package com.usuarios.usuariosBackend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuarios.usuariosBackend.modelo.Usuario;
import com.usuarios.usuariosBackend.repositorio.UsuarioRepositorio;
import com.usuarios.usuariosBackend.servicios.UsuarioServicio;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200")
public class usuarioControlador{
	@Autowired
	private UsuarioServicio servicio;
	
	@PostMapping("/")
	public Usuario regUsuario(@RequestBody Usuario usuario) throws Exception{
		return servicio.regUsuario(usuario);
	}
	
	

}
