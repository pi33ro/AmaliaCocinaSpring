package com.empresa.demo.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.Conexion;
import com.empresa.demo.interfaz.IPlato;
import com.empresa.demo.model.Categoria;
import com.empresa.demo.model.Plato;
import com.empresa.demo.servicioInterfaz.IPlatoService;

@Service
public class PlatoServices implements IPlatoService {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Conexion cn=new Conexion();
	

	@Autowired
	IPlato data;
	
	@Override
	public List<Plato> listar() {
		
		return (List<Plato>) data.findAll();
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
	
	public Plato listarId(String id) {
		String sql="select * from plato where id_plato=" +id;
		Plato p=new Plato();
		Categoria c=new Categoria();
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				p.setId_plato(rs.getString(1));
				c.setId_categoria(rs.getString(2));
				p.setNombre(rs.getString(3));
				p.setPrecio(rs.getDouble(4));
				p.setDescripcion(rs.getString(5));
				p.setStock(rs.getInt(6));
				p.setImagen(rs.getNString(7));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return p;
	}

}
