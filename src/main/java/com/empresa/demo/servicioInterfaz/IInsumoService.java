package com.empresa.demo.servicioInterfaz;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.empresa.demo.model.Insumo;

@Repository
public interface IInsumoService {
	
	public List<Insumo> listar();
	public Optional<Insumo> buscarId(String id);
	public void eliminar(String id);
	public void saveProcedure(Insumo i);
	

}

