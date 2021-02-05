package com.empresa.demo.interfaz;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.demo.model.Cliente;

public interface ICliente extends JpaRepository<Cliente, String> {
	
	@Transactional
	@Modifying
	@Query(value="{CALL REGISTRAR_CLIENTE(:nombreIn,:apellidoIn,:telefonoIn,:direccionIn,:dniIn)}",nativeQuery=true)
	void saveProcedure(
			@Param("nombreIn")String nombreIn,
			@Param("apellidoIn")String apellidoIn,
			@Param("telefonoIn")String telefonoIn,
			@Param("direccionIn")String direccionIn,
			@Param("dniIn")String dniIn
			);

}
