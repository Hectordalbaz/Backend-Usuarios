package com.usuarios.usuariosBackend.modelo;

public class JwtRequest {
	private String clave;
	private String contrasena;
	public JwtRequest() {
	}
	public JwtRequest(String clave, String contrasena) {
		super();
		this.clave = clave;
		this.contrasena = contrasena;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	

}
