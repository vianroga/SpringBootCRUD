/**
 * Creado por: Victor Roman Garrido
 * Fecha:9/09/2021 11:53:11 p. m.
 */
package com.pruebas.SpringHelloMundo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * @author Victor Roman Garrido
 *
 */
@Entity
@Data
@Table(name="rol")
public class Rol implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRol;
	@NotEmpty
	private String nombre;	
	 	

}
