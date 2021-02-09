package com.empresa.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="trabajador")
public class Trabajador implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_trabajador;
	
	@Column(name="nombre",length=20)
	private String nombre;
	
	@Column(name="apellido",length=20)
	private String apellido;
	
	@Column(name="telefono",length=9)
	private String telefono;
	
	@Column(name="dni",length=8)
	private int dni;
	
	@OneToMany(mappedBy="trabajador")
	private Collection<Almacen> itemsAlmacen=new ArrayList();

	
	
	public Trabajador() {
		super();
	}

	public Trabajador(int id_trabajador, String nombre, String apellido, String telefono, int dni) {
		super();
		this.id_trabajador = id_trabajador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.dni = dni;
	}

	public int getId_trabajador() {
		return id_trabajador;
	}

	public void setId_trabajador(int id_trabajador) {
		this.id_trabajador = id_trabajador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
	

}