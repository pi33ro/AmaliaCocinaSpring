package com.empresa.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//aea
@Entity
@Table(name="almacen")
public class Almacen implements Serializable{
	
	@Id
	private String id_almacen; 

	@Column(name="clase",length=30)
	private String clase;
	
	@Column(name="descripcion",length=45)
	private String descripcion;
	
	@OneToMany(mappedBy="almacen")
	private Collection<Insumo> itemsInsumo=new ArrayList();
	
	@ManyToOne
	@JoinColumn(name="idtrabajador",
			foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(idtrabajador) references trabajador(id_trabajador)"))
	private Trabajador trabajador;
	

	public Almacen() {
		super();
	}

	

	public Almacen(String id_almacen, String clase, String descripcion,
			Trabajador trabajador) {
		super();
		this.id_almacen = id_almacen;
		this.clase = clase;
		this.descripcion = descripcion;
		this.trabajador = trabajador;
	}



	public String getId_almacen() {
		return id_almacen;
	}

	public void setId_almacen(String id_almacen) {
		this.id_almacen = id_almacen;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Trabajador getTrabajador() {
		return trabajador;
	}



	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	
	
}

