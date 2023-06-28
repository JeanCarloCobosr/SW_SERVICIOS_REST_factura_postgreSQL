package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Factura;
import com.cibertec.repository.FacturaRepository;

@Service
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	private FacturaRepository repository;

	@Override
	public List<Factura> listaFactura() {
		return repository.findAll();
	}

	@Override
	public Factura insertaFactura(Factura obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Factura> buscaFactura(int idFactura) {
		return repository.findById(idFactura);
	}

	@Override
	public void eliminaFactura(int idFactura) {
		repository.deleteById(idFactura);
	}
	
	@Override
	public List<Factura> listarPorTipoMoneda(int idTipoMoneda) {
		return repository.listarPorTipoMoneda(idTipoMoneda);
	}

}
