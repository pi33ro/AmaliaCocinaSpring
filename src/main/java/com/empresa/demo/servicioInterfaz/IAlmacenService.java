package com.empresa.demo.servicioInterfaz;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.empresa.demo.model.Almacen;

@Repository
public interface IAlmacenService {
	
	public List<Almacen> listar();
	public Optional<Almacen> buscarId(String id);
	public void eliminar(String id);
	public void saveProcedure(Almacen a);

}

