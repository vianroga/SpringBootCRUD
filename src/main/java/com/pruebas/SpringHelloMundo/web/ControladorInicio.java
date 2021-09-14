/**
 * Creado por: Victor Roman Garrido
 * Fecha:3/09/2021 1:14:47 p. m.
 */
package com.pruebas.SpringHelloMundo.web;


import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pruebas.SpringHelloMundo.domain.Persona;
import com.pruebas.SpringHelloMundo.servicio.PersonaService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Victor Roman Garrido	
 *	
 */	
@Controller	
@Slf4j
public class ControladorInicio {
													
	//Accediendo al archivo aplication.properties
	//@Value("${index.saludo}")
	//private String saludo;
	
	@Autowired
	private PersonaService personaService;

	@GetMapping("/")
	public String inicio(Model model, @AuthenticationPrincipal User user) {
		log.info("Ejecutando MVC");
		var personas = personaService.ListarPersonas();
		log.info("Usuario que realizo login: "+user);
		model.addAttribute("Personas", personas);
		var saldoTotal = 0D;
		for (var p : personas) {
			saldoTotal+=p.getSaldo();
		}
		model.addAttribute("saldoTotal", saldoTotal);
		model.addAttribute("totalClientes", personas.size());
		return "index";
	}
	@GetMapping("/agregar")
	public String agregar (Persona persona) {
		return "modificar";	
	}
	@PostMapping("/guardar")
	public String guardar(@Valid Persona persona, Errors errors) {
		if (errors.hasErrors()) {
			return "modificar";
		}
		personaService.guardar(persona);
		return "redirect:/";
	}
	@GetMapping("/editar/{idPersona}")
	public String editar(Persona persona, Model model) {
		persona=personaService.encontrarPersona(persona);
		model.addAttribute("persona", persona);
		return "modificar";
	}
	@GetMapping("/eliminar")
	public String eliminar(Persona persona, Model model) {
		persona=personaService.encontrarPersona(persona);
		personaService.eliminar(persona);
		return "redirect:/";
		
	}
	
}
