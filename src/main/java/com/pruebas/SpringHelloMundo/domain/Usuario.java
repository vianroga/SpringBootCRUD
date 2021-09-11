/**
 * Creado por: Victor Roman Garrido
 * Fecha:9/09/2021 11:59:00 p. m.
 */
package com.pruebas.SpringHelloMundo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * @author Victor Roman Garrido
 *
 */

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	@OneToMany 
	@JoinColumn(name="id_usuario")
	private List<Rol> roles;

}
