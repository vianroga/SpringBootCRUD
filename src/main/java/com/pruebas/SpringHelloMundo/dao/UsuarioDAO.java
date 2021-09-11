/**
 * Creado por: Victor Roman Garrido
 * Fecha:10/09/2021 12:04:50 a. m.
 */
package com.pruebas.SpringHelloMundo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebas.SpringHelloMundo.domain.Usuario;

/**
 * @author Victor Roman Garrido
 *
 */
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
	Usuario findByUsername(String username);
}
