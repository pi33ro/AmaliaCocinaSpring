package com.empresa.demo.servicio;

import java.util.List;
import java.util.Optional;

import com.empresa.demo.interfaz.IUsers;
import com.empresa.demo.model.Users;
import com.empresa.demo.servicioInterfaz.IUsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements IUsersService{
	
	@Autowired
	IUsers data;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;

	@Override
	public List<Users> listar() {
		return data.findAll();
	}

	@Override
	public Optional<Users> buscarId(int id) {
		return data.findById(id);
	}

	@Override
	public void eliminar(int id) {
		data.deleteById(id);
		
	}

	@Override
	public int guardar(Users p) {
		int res=0;
		String password =p.getPassword();
		p.setPassword(passEncoder.encode(password));
		Users login=data.save(p);
		if(!login.equals(null)) {
			res=1;
		}
		return res;
	}

}
