package com.empresa.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.demo.interfaz.ICategoria;
import com.empresa.demo.model.Categoria;
import com.empresa.demo.servicioInterfaz.ICategoriaService;

@Service
public class CategoriaServices implements ICategoriaService {

	@Autowired
	ICategoria data;
	
	@Override
	public List<Categoria> listar() {
		
		return (List<Categoria>) data.findAll();
	}
	
	

}
