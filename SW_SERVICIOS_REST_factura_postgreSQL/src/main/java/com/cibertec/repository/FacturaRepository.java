package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
	@Query("Select p from Factura p where p.idTipoMoneda = :var_TipoMoneda")
	public abstract List<Factura> listarPorTipoMoneda(@Param("var_TipoMoneda") int idTipoMoneda);
	
	
}
