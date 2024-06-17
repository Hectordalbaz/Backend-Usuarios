package com.usuarios.usuariosBackend.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.usuarios.usuariosBackend.servicios.impl.DetUsuarioServicioImpl;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfigSeguridad {

	@Autowired
	private JwtPuntoAuten unautorizedHandler;

	@Autowired
	DetUsuarioServicioImpl DetServicioUsuario;

	@Autowired
	private JwtFiltroAut jwtFiltroAut;


	@Bean
	  public DaoAuthenticationProvider authenticationProvider() {
	      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	       
	      authProvider.setUserDetailsService(DetServicioUsuario);
	      authProvider.setPasswordEncoder(passwordEncoder());
	   
	      return authProvider;
	  }
	@Bean
	  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
	    return authConfig.getAuthenticationManager();
	  }

    @Bean
    public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
    
    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    	auth.userDetailsService(this.DetServicioUsuario).passwordEncoder(passwordEncoder());
    }
	  
	  @Bean
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
	        .exceptionHandling(exception -> exception.authenticationEntryPoint(unautorizedHandler))
	        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	        .authorizeHttpRequests(auth -> 
	          auth.requestMatchers("/generar-token","/usuarios/").permitAll()
	              .anyRequest().authenticated()
	        );
	    
	    http.authenticationProvider(authenticationProvider());

	    http.addFilterBefore(jwtFiltroAut, UsernamePasswordAuthenticationFilter.class);
	    
	    return http.build();
	  }
}
