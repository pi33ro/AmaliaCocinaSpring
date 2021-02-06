package com.empresa.demo.interfaz;

import org.springframework.data.repository.CrudRepository;

import com.empresa.demo.model.Categoria;

public interface ICategoria extends CrudRepository<Categoria, String> {

}
