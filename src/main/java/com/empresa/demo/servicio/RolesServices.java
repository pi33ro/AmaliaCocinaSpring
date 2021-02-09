package com.empresa.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.demo.interfaz.IRoles;
import com.empresa.demo.model.Roles;
import com.empresa.demo.servicioInterfaz.IRolesService;

@Service
public class RolesServices implements IRolesService{
	
	@Autowired
	IRoles data;

	@Override
	public List<Roles> listar() {
		return (List<Roles>) data.findAll();
	}

	@Override
	public Optional<Roles> buscarId(int id) {
		return data.findById(id);
	}

	@Override
	public void eliminar(int id) {
		data.deleteById(id);
		
	}

	@Override
	public int guardar(Roles p) {
		int res=0;
		Roles login=data.save(p);
		if(!login.equals(null)) {
			res=1;
		}
		return res;
	}

}
