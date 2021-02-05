package com.empresa.demo.servicioInterfaz;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.empresa.demo.model.Cliente;


@Repository
public interface IClienteService {
	
	public List<Cliente> listar();
	public Optional<Cliente> buscarId(String id);
	public void eliminar(String id);
	public void saveProcedure(Cliente c);

}
