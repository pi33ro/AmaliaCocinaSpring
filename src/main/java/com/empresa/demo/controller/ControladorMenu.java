package com.empresa.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class ControladorMenu {
	
	@GetMapping("/menu")
	public String index() {
		
		return "index";
	}
	
	@GetMapping(value="/vista_cliente")
	public String vistaPersona() {
		return "vistapersona";
	}

}
