package com.empresa.demo.servicioInterfaz;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.empresa.demo.model.Roles;

@Repository
public interface IRolesService {
	
	public List<Roles> listar();
	public Optional<Roles> buscarId(int id);
	public void eliminar(int id);
	public int guardar(Roles p);

}
