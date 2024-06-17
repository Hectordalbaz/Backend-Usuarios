package com.usuarios.usuariosBackend.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sesiones")
public class Sesion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_sesion;
	
	@ManyToOne
	@JoinColumn(name= "id_usuario",nullable=false)
	private Usuario usuario;
	
	@Column(name = "Fec_Hor_Ini_Ses", length = 255, nullable = false)
	private Date fec_hor_ini_ses;

	
	public Sesion() {

	}


	public Sesion(Long id_sesion, Usuario usuario, Date fec_hor_ini_ses) {
		super();
		this.id_sesion = id_sesion;
		this.usuario = usuario;
		this.fec_hor_ini_ses = fec_hor_ini_ses;
	}


	public Long getId_sesion() {
		return id_sesion;
	}


	public void setId_sesion(Long id_sesion) {
		this.id_sesion = id_sesion;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Date getFec_hor_ini_ses() {
		return fec_hor_ini_ses;
	}


	public void setFec_hor_ini_ses(Date fec_hor_ini_ses) {
		this.fec_hor_ini_ses = fec_hor_ini_ses;
	}
	
	
	

	
	
	
	

}
