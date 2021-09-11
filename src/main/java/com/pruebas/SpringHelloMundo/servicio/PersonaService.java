/**
 * Creado por: Victor Roman Garrido
 * Fecha:8/09/2021 2:05:06 p. m.
 */
package com.pruebas.SpringHelloMundo.servicio;

import java.util.List;

import com.pruebas.SpringHelloMundo.domain.Persona;

/**
 * @author Victor Roman Garrido
 *
 */
public interface PersonaService {

	//Crear CRUD
	public List<Persona> ListarPersonas();
	public void guardar(Persona persona);
	public void eliminar(Persona persona); 
	public Persona encontrarPersona(Persona persona);

}
