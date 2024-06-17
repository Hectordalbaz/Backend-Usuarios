package com.usuarios.usuariosBackend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuarios.usuariosBackend.modelo.Sesion;

public interface SesionRepositorio extends JpaRepository<Sesion, Long>{

}
