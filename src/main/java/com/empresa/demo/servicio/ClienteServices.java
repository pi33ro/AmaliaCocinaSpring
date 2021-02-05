package com.empresa.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.demo.interfaz.ICliente;
import com.empresa.demo.model.Cliente;
import com.empresa.demo.servicioInterfaz.IClienteService;

@Service
public class ClienteServices implements IClienteService{
	
	@Autowired
	ICliente data;

	@Override
	public List<Cliente> listar() {
		
		return (List<Cliente>) data.findAll();
	}

	@Override
	public Optional<Cliente> buscarId(String id) {
		return data.findById(id);
	}

	@Override
	public void eliminar(String id) {
		
		data.deleteById(id);
		
	}

	@Override
	public void saveProcedure(Cliente c) {
	
		data.saveProcedure(c.getNombre(), c.getApellido(), c.getTelefono(), c.getDireccion(), c.getDni());
	}

}
