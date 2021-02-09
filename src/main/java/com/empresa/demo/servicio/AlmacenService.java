package com.empresa.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.empresa.demo.interfaz.IAlmacen;
import com.empresa.demo.model.Almacen;
import com.empresa.demo.model.Trabajador;
import com.empresa.demo.servicioInterfaz.IAlmacenService;


@Service
public class AlmacenService implements IAlmacenService{
	
	@Autowired
	IAlmacen almacen;

	@Override
	public List<Almacen> listar() {
		return (List<Almacen>) almacen.findAll();
	}

	@Override
	public Optional<Almacen> buscarId(String id) {
		return almacen.findById(id);
	}

	@Override
	public void eliminar(String id) {
		almacen.deleteById(id);
		
	}

	@Override
	public void saveProcedure(Almacen a) {
		almacen.saveProcedure(a.getClase(), a.getDescripcion(), a.getTrabajador());
		
	}

	
	
}

