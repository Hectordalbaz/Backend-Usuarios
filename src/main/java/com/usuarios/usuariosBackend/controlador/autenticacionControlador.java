package com.usuarios.usuariosBackend.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usuarios.usuariosBackend.modelo.JwtRequest;
import com.usuarios.usuariosBackend.modelo.JwtResponse;
import com.usuarios.usuariosBackend.seguridad.JwtUtil;
import com.usuarios.usuariosBackend.servicios.impl.DetUsuarioServicioImpl;

@RestController
@CrossOrigin("*")
public class autenticacionControlador {

	@Autowired
	private  AuthenticationManager autMan;
	
	@Autowired
	private DetUsuarioServicioImpl DetServicioUsuario;
	
	@Autowired
	private  JwtUtil jwtUtil;
	
	@PostMapping("/generar-token")
	public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtrequest) throws Exception{
		try {
			autenticar(jwtrequest.getClave(),jwtrequest.getContrasena());
		}catch(Exception ex){
			ex.printStackTrace();
			throw new Exception("Usuario no encontrado");
		}
		UserDetails detUsu=this.DetServicioUsuario.loadUserByUsername(jwtrequest.getClave());
		String token=this.jwtUtil.generateToken(detUsu);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void autenticar(String clave, String contrasena) throws Exception {
		try {
			autMan.authenticate(new UsernamePasswordAuthenticationToken(clave,contrasena));
		}catch(DisabledException de) {
			throw new Exception("USUARIO DESHABILITADO "+de.getMessage());
		}catch(BadCredentialsException bce) {
			throw new Exception("Credenciales invalidas"+bce.getMessage());
		}
	}
}
