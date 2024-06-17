package com.usuarios.usuariosBackend.seguridad;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.usuarios.usuariosBackend.servicios.impl.DetUsuarioServicioImpl;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFiltroAut extends OncePerRequestFilter {

	@Autowired
	private DetUsuarioServicioImpl detUsuarioService;

	@Autowired
	private JwtUtil jwtUtils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String reqTokenHeader = request.getHeader("Authorization");
		String clave = null;
		String jwtToken = null;

		if (reqTokenHeader != null && reqTokenHeader.startsWith("Bearer ")) {
			jwtToken = reqTokenHeader.substring(7);
			try {
				clave = this.jwtUtils.extractUsername(jwtToken);
			} catch (ExpiredJwtException ejex) {
				System.out.println("El token ha expirado");
			} catch (Exception ex) {

			}
		} else {
			System.out.print("Token invalido no comienza con Bearer");
		}

		if (clave != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.detUsuarioService.loadUserByUsername(clave);
			if (this.jwtUtils.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(userDetails, null,
						userDetails.getAuthorities());
				upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(upat);
			} else {
				System.out.println("El token no es valido");
			}
			filterChain.doFilter(request, response);
		}
	}

}
