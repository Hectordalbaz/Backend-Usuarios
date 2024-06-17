package com.usuarios.usuariosBackend.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;

	@Column(name = "Clave", length = 255, nullable = false, unique = true)
	private String clave;
	
	@Column(name = "Nombre", length = 255, nullable = false)
	private String nombre;
	
	@Column(name = "Contrasena", length = 255, nullable = false)
	private String contrasena;
	
	@Column(name = "Estado", length = 255, nullable = false)
	private boolean estado;
	
	@Column(name = "Fec_Hor_Creacion", length = 255, nullable = false)
	private Date fec_hor_creacion;
	
	@Column(name = "Fec_Hor_Ult_Mod", length = 255, nullable = false)
	private Date fec_hor_ult_mod;
	
	@Column(name = "Usu_Ult_Mod", length = 255, nullable = false)
	private String usu_ult_mod;


	public Usuario(Long id_usuario, String clave, String nombre, String contrasena, boolean estado,
			Date fec_hor_creacion, Date fec_hor_ult_mod, String usu_ult_mod) {
		super();
		this.id_usuario = id_usuario;
		this.clave = clave;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.estado = estado;
		this.fec_hor_creacion = fec_hor_creacion;
		this.fec_hor_ult_mod = fec_hor_ult_mod;
		this.usu_ult_mod = usu_ult_mod;
	}


	public Usuario() {
		
	}


	public Long getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public Date getFec_hor_creacion() {
		return fec_hor_creacion;
	}


	public void setFec_hor_creacion(Date fec_hor_creacion) {
		this.fec_hor_creacion = fec_hor_creacion;
	}


	public Date getFec_hor_ult_mod() {
		return fec_hor_ult_mod;
	}


	public void setFec_hor_ult_mod(Date fec_hor_ult_mod) {
		this.fec_hor_ult_mod = fec_hor_ult_mod;
	}


	public String getUsu_ult_mod() {
		return usu_ult_mod;
	}


	public void setUsu_ult_mod(String usu_ult_mod) {
		this.usu_ult_mod = usu_ult_mod;
	}
	
	
	
	

}
