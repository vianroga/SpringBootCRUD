/**
 * Creado por: Victor Roman Garrido
 * Fecha:3/09/2021 3:13:29 p. m.
 */
package com.pruebas.SpringHelloMundo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * @author Victor Roman Garrido
 *
 */

@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPersona;
	
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellido;
	@NotEmpty
	@Email
	private String email;
	private String telefono;
}
