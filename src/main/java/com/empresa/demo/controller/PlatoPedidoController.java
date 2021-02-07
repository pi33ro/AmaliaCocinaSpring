package com.empresa.demo.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empresa.demo.model.Carrito;
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
	
	List<Carrito> listaCarrito=new ArrayList<>();
	int item = 0;
	double totalPagar=0.0;
	int cantidad=1;
	
	@GetMapping(value="/agregarcarrito/{id}")
	public String agregarCarrito(@PathVariable String id,Model model) {
		
		
		Plato pl=service.listarId(id);
		
		//

		//
		item=item+1;
		
		Carrito car=new Carrito();
		car.setItem(item);
		car.setIdProducto(pl.getId_plato());
		car.setNombres(pl.getNombre());
		car.setDescripcion(pl.getDescripcion());
		car.setPrecioCompra(pl.getPrecio());
		car.setCantidad(cantidad);
		car.setSubTotal(cantidad*pl.getPrecio());
		listaCarrito.add(car);
		
		model.addAttribute("contador", listaCarrito.size());
		return "listaplatospedidos";

	}
	

}
