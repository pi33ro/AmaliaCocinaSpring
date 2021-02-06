package com.empresa.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.demo.interfaz.IPlato;
import com.empresa.demo.model.Plato;
import com.empresa.demo.servicioInterfaz.IPlatoService;

@Service
public class PlatoServices implements IPlatoService {

	@Autowired
	IPlato data;
	
	@Override
	public List<Plato> listar() {
		
		return data.findAll();
	}

	@Override
	public Optional<Plato> buscarId(String id) {
		
		return data.findById(id);
	}

	@Override
	public void eliminar(String id) {
		
		data.deleteById(id);
	}

	@Override
	public void saveProcedure(Plato c) {
		data.saveProcedure(c.getCategoria(), c.getNombre(),c.getPrecio(), c.getDescripcion(), c.getStock(), c.getImagen());
		
	}

}
