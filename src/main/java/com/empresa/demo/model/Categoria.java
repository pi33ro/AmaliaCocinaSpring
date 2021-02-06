package com.empresa.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id_categoria;
	@Column(name="nombre")
	private String nombre;
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}

	public Categoria(String id_categoria, String nombre) {
		super();
		this.id_categoria = id_categoria;
		this.nombre = nombre;
	}

	public String getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(String id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//PARA MOSTRA EL NOMBRE DE LA CATEGORIA EN LA LISTA
	@Override
	public String toString() {
		return "Tipo" + nombre ;
	}


	

}
