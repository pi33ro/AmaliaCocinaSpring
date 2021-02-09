package com.empresa.demo.interfaz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.demo.model.Almacen;
import com.empresa.demo.model.Insumo;

public interface IInsumo extends JpaRepository<Insumo, String>{
	
	
	@Transactional
	@Modifying
	@Query(value="{CALL REGISTRAR_Insumos(:nombreIn, :precioIn, :idalmacenIn)}",nativeQuery=true)
	void saveProcedure(
			@Param("nombreIn")String nombreIn,
			@Param("precioIn")float precioIn,
			@Param("idalmacenIn")Almacen almacen
			);

}