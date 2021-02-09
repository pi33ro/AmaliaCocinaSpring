package com.empresa.demo.interfaz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.demo.model.Almacen;
import com.empresa.demo.model.Trabajador;

public interface IAlmacen extends JpaRepository<Almacen, String>{
	
	
	@Transactional
	@Modifying
	@Query(value="{CALL REGISTRAR_ALMACEN(:claseIn, :descripcionIn, :idtrabajadorIn)}",nativeQuery=true)
	void saveProcedure(
			@Param("claseIn")String claseIn,
			@Param("descripcionIn")String descripcionIn,
			@Param("idtrabajadorIn")Trabajador trabajador
			);
	
}