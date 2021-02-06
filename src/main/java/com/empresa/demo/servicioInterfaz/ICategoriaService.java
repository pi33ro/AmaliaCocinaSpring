package com.empresa.demo.servicioInterfaz;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.empresa.demo.model.Categoria;

@Repository
public interface ICategoriaService {
	
	 public List<Categoria> listar();

}
