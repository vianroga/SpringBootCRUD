/**
 * Creado por: Victor Roman Garrido
 * Fecha:7/09/2021 1:43:27 p. m.
 */
package com.pruebas.SpringHelloMundo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebas.SpringHelloMundo.domain.Persona;

/**
 * @author Victor Roman Garrido
 *
 */
public interface PersonaDao extends JpaRepository<Persona, Long> {

}
