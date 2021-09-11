/**
 * Creado por: Victor Roman Garrido
 * Fecha:9/09/2021 11:43:50 p. m.
 */
package com.pruebas.SpringHelloMundo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Victor Roman Garrido
 *
 */
public class EncriptarPassword {
	public static void main(String[] args) {
		var password = "123";
		System.out.println("pass sin encriptar: " + password);
		System.out.println("Pass encriptada: " + encriptarPassword(password));
	}

	public static String encriptarPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
}
