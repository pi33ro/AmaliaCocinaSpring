package com.empresa.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empresa.demo.model.Categoria;
import com.empresa.demo.model.Plato;
import com.empresa.demo.servicio.CategoriaServices;
import com.empresa.demo.servicio.PlatoServices;

@Controller
@RequestMapping
public class PlatoController {
	
	@Autowired
	PlatoServices service;
	
	@Autowired
	CategoriaServices Catservice;
	
	@GetMapping("/listaplato")
	public String listar(Model model) {
		List<Plato> platos=service.listar();
		model.addAttribute("platos",platos);
		return "listaplato";
		
	}
	
	@GetMapping("/nuevoplato")
	public String nuevo(Model model) {
		Plato plato=new Plato();
		List<Categoria> listCategorias=Catservice.listar();
		
		model.addAttribute("plato",plato);
		model.addAttribute("categorias",listCategorias);
		return "platoform";
	}
	
	@PostMapping("/guardarplato")
	public String guardar(@Validated @ModelAttribute Plato p, BindingResult result, 
			Model model, @RequestParam("file") MultipartFile imagen, RedirectAttributes attribute) {
		
		if(!imagen.isEmpty()) {
			Path directorioImagenes  =Paths.get("src//main//resources//static//image/productos");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta= Paths.get(rutaAbsoluta+"//"+imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				
				p.setImagen(imagen.getOriginalFilename());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		service.saveProcedure(p);
		return "redirect:/listaplato";
	}
	
	@GetMapping("/editarplato/{id}")
	public String editar(@PathVariable String id, Model model) {
		Optional<Plato> plato = service.buscarId(id);
		List<Categoria> listCategorias=Catservice.listar();
		model.addAttribute("plato", plato);
		model.addAttribute("categorias",listCategorias);
		return "platoform";
	}
	
	@GetMapping("/eliminarplato/{id}")
	public String delete(Model model, @PathVariable String id) {
		service.eliminar(id);
		return "redirect:/listaplato";
	}
	
	


}
