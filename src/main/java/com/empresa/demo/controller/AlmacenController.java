package com.empresa.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.demo.model.Almacen;
import com.empresa.demo.model.Insumo;
import com.empresa.demo.servicio.AlmacenService;

@Controller
@RequestMapping
public class AlmacenController {
	
	@Autowired
	AlmacenService almacenService;
	
	@GetMapping("/listaalmacen")
	public String listar(Model model) {
		
		List<Almacen> almacen=almacenService.listar();
		
		model.addAttribute("almacen",almacen);
		
		return "listaalmacen";
	}
	
	@GetMapping("/nuevoalmacen")
	public String nuevo(Model model) {
		
		Almacen almacen=new Almacen();
		
		model.addAttribute("almacen",almacen);
		
		return "almacenform";
	}
	
}
