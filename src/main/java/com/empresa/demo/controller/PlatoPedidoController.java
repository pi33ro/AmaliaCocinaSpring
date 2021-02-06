package com.empresa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empresa.demo.model.Plato;
import com.empresa.demo.servicio.PlatoServices;

@Controller
@RequestMapping
public class PlatoPedidoController {
	
	@Autowired
	PlatoServices service;
	
	@GetMapping(value="/platospedidos")
	public String vistaPlatosPedidos(Model model) {
		
		List<Plato> platos=service.listar();
		model.addAttribute("platos",platos);
		return "listaplatospedidos";
	}

}
