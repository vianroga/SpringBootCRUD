/**
 * Creado por: Victor Roman Garrido
 * Fecha:8/09/2021 2:11:24 p. m.
 */
package com.pruebas.SpringHelloMundo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebas.SpringHelloMundo.dao.PersonaDao;
import com.pruebas.SpringHelloMundo.domain.Persona;

/**
 * @author Victor Roman Garrido
 *
 */
@Service
public class PersonaServiceImpl implements PersonaService {
	
	
	@Autowired
	private PersonaDao personaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Persona> ListarPersonas() {
		// TODO Auto-generated method stub
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Persona persona) {
		// TODO Auto-generated method stub
		personaDao.save(persona);
	}

	@Override
	@Transactional
	public void eliminar(Persona persona) {
		// TODO Auto-generated method stub
		personaDao.delete(persona);
	}

	@Override
	@Transactional(readOnly = true)
	public Persona encontrarPersona(Persona persona) {
		// TODO Auto-generated method stub
		return personaDao.findById(persona.getIdPersona()).orElse(null);
	}
	
}
