package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.entity.Factura;

public interface FacturaService {

	public List<Factura> listaFactura();

	public Factura insertaFactura(Factura obj);

	public Optional<Factura> buscaFactura(int idFactura);

	public void eliminaFactura(int idFactura);
	
	public abstract List<Factura> listarPorTipoMoneda(int idTipoMoneda);


}
