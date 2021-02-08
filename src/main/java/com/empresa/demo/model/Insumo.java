package com.empresa.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name="insumos")
public class Insumo{
	
	@Id
	private String id_insumo;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="precio")
	private float precio;
	
	@ManyToOne
	@JoinColumn(name="idalmacen",
	foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(idalmacen) references almacen(id_almacen)"))
	private Almacen almacen;

	public Insumo() {
		super();
	}


	

	public Insumo(String id_insumo, String nombre, float precio, Almacen almacen) {
		super();
		this.id_insumo = id_insumo;
		this.nombre = nombre;
		this.precio = precio;
		this.almacen = almacen;
	}




	public String getId_insumo() {
		return id_insumo;
	}

	public void setId_insumo(String id_insumo) {
		this.id_insumo = id_insumo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public Almacen getAlmacen() {
		return almacen;
	}



	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}


	

}

