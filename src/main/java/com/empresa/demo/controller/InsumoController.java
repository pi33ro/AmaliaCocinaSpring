package com.empresa.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empresa.demo.model.Insumo;
import com.empresa.demo.servicio.InsumoServices;


@Controller
@RequestMapping
public class InsumoController {
	
	@Autowired
	InsumoServices servicio;
	
	@GetMapping("/listainsumo")
	public String listar(Model model) {
		
		List<Insumo> insumos=servicio.listar();
		
		model.addAttribute("insumos",insumos);
		
		return "listainsumo";
	}
	
	@GetMapping("/nuevoinsumo")
	public String nuevo(Model model) {
		
		Insumo insumo=new Insumo();
		
		model.addAttribute("insumo",insumo);
		
		return "insumoform";
	}
	
	
	@PostMapping("/saveinsumo")
	public String guardar(Insumo i) {
		
		servicio.saveProcedure(i);
		
		return "redirect:/listainsumo";
	}

}


