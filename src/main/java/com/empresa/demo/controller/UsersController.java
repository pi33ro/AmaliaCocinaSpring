package com.empresa.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empresa.demo.model.Roles;
import com.empresa.demo.model.Users;
import com.empresa.demo.servicio.RolesServices;
import com.empresa.demo.servicio.UsersService;

@Controller
@RequestMapping
public class UsersController {
	
	@Autowired
	UsersService service;
	
	@Autowired
	RolesServices service2;
	
	@GetMapping("/listausers")
	public String listar(Model model) {
		List<Users> users=service.listar();
		model.addAttribute("users",users);
		return "listausers";
		
	}
	
	@GetMapping("/nuevousers")
	public String nuevo(Model model) {
		Users users=new Users();
		Roles roles=new Roles();
		model.addAttribute("users",users);
		model.addAttribute("roles",roles);
		return "usersform";
	}
	
	
	@PostMapping("/guardarusers")
	public String guardar(Users p, Roles r) {
		service.guardar(p);
		service2.guardar(r);
		return "listo";
	}
	
	@GetMapping("/editarusers/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Users> users = service.buscarId(id);
		model.addAttribute("users", users);
		return "usersform";
	}
	
		
	@GetMapping("/eliminarusers/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.eliminar(id);
		return "redirect:/listausers";
	}
	
	@GetMapping("/listo")
	public String listo() {
		return "listo";
	}

}
