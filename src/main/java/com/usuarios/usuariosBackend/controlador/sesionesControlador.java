package com.usuarios.usuariosBackend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuarios.usuariosBackend.modelo.Sesion;
import com.usuarios.usuariosBackend.repositorio.SesionRepositorio;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200")
public class sesionesControlador {
	@Autowired
	private SesionRepositorio repositorio;
	
	@GetMapping("/sesiones")
	public List<Sesion> listarSesiones(){
		return repositorio.findAll();
	}
	

}
