package com.empresa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empresa.demo.model.Cliente;
import com.empresa.demo.servicio.ClienteServices;


@Controller
@RequestMapping
public class ClienteController {
	
	@Autowired
	ClienteServices service;
	
	@GetMapping("/listacliente")
	public String listar(Model model) {
		
		List<Cliente> clientes=service.listar();
		
		model.addAttribute("clientes",clientes);
		
		return "listacliente";
		
	}
	
	@GetMapping("/nuevocliente")
	public String nuevo(Model model) {
		
		Cliente cliente=new Cliente();
		
		model.addAttribute("cliente",cliente);
		
		return "clienteform";
	}
	
	@PostMapping("/savecliente")
	public String guardar(Cliente c) {
		
		service.saveProcedure(c);
		
		return "redirect:/listacliente";
	}

}
