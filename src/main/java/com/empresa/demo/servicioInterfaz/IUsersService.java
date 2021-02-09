package com.empresa.demo.servicioInterfaz;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.empresa.demo.model.Users;


@Repository
public interface IUsersService {
	
	public List<Users> listar();
	public Optional<Users> buscarId(int id);
	public void eliminar(int id);
	public int guardar(Users p);

}
