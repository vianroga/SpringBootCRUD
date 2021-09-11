/**
 * Creado por: Victor Roman Garrido
 * Fecha:10/09/2021 12:12:47 a. m.
 */
package com.pruebas.SpringHelloMundo.servicio;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebas.SpringHelloMundo.dao.UsuarioDAO;
import com.pruebas.SpringHelloMundo.domain.Rol;
import com.pruebas.SpringHelloMundo.domain.Usuario;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Victor Roman Garrido
 *
 */
@Service("userDetailsService")
@Slf4j
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private UsuarioDAO usuarioDAO ;

	@Override	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Usuario usuario = usuarioDAO.findByUsername(username);
		
		if (usuario==null) {
			throw new UsernameNotFoundException(username);
		}
		var roles = new  ArrayList<GrantedAuthority>();
		
		for (Rol rol : usuario.getRoles()) {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		}
		return new User(usuario.getUsername(), usuario.getPassword(), roles);
		
	}

}
