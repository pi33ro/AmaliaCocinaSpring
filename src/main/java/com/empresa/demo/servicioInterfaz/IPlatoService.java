package com.empresa.demo.servicioInterfaz;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.empresa.demo.model.Plato;

@Repository
public interface IPlatoService {
	
	public List<Plato> listar();
	public Optional<Plato> buscarId(String id);
	public void eliminar(String id);
	public void saveProcedure(Plato c);

}
