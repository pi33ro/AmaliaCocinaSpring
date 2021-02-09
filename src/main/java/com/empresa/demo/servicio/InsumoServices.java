package com.empresa.demo.servicio;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.demo.interfaz.IInsumo;
import com.empresa.demo.model.Insumo;
import com.empresa.demo.servicioInterfaz.IInsumoService;


@Service
public class InsumoServices implements IInsumoService{
	
	@Autowired
	IInsumo insumo;

	@Override
	public List<Insumo> listar() {
		
		return (List<Insumo>) insumo.findAll();
	}

	@Override
	public Optional<Insumo> buscarId(String id) {
		return insumo.findById(id);
	}

	@Override
	public void eliminar(String id) {
		insumo.deleteById(id);
		
	}

	@Override
	public void saveProcedure(Insumo i) {
		insumo.saveProcedure(i.getNombre(), i.getPrecio(), i.getAlmacen());
		
	}

}

