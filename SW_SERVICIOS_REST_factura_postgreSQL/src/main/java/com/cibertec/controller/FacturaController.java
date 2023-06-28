package com.cibertec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Factura;
import com.cibertec.service.FacturaService;

@RestController
@RequestMapping("/rest/factura")
public class FacturaController {

	@Autowired
	private FacturaService service;

	@GetMapping()
	public ResponseEntity<?> lista() {
		List<Factura> lstSalida = service.listaFactura();
		return ResponseEntity.ok(lstSalida);
	}
	
	@PostMapping
	public ResponseEntity<?> inserta(@RequestBody Factura obj) {
		Factura objSalida = service.insertaFactura(obj);
		return ResponseEntity.ok(objSalida);
	}

	@GetMapping("/porId/{id}")
	public ResponseEntity<?> listaPorIdEnPath(@PathVariable Integer id) {
		Optional<Factura> optSalida = service.buscaFactura(id);
		return ResponseEntity.ok(optSalida.get());
	}
	
	@GetMapping("/porId")
	public ResponseEntity<?> listaPorIdEnParamaterer(
			@RequestParam(name = "id", defaultValue = "0", required = true) Integer id) {
		Optional<Factura> optSalida = service.buscaFactura(id);
		return ResponseEntity.ok(optSalida.get());
	}
	
	
	@GetMapping("/porFactura/{id}")
	public ResponseEntity<?> listaPorTipoMoneda(@PathVariable Integer id) {
		List<Factura> lstSalida = service.listarPorTipoMoneda(id);
		return ResponseEntity.ok(lstSalida);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminaFactura(@PathVariable Integer id) {
		service.eliminaFactura(id);
		Optional<Factura> optFactura = service.buscaFactura(id);
		if (optFactura.isEmpty()) {
			return ResponseEntity.ok("Eliminación exitosa");
		}
		return ResponseEntity.ok("No existe el id " + id);
	}
	
	@PutMapping
	public ResponseEntity<?> actualiza(@RequestBody Factura obj) {
		Optional<Factura> optFactura = service.buscaFactura(obj.getIdFactura());
		if (optFactura.isPresent()) {
			Factura objSalida = service.insertaFactura(obj);
			return ResponseEntity.ok(objSalida);
		} else {
			return ResponseEntity.ok("La Factura no existe");
		}
	}
	
	
	
}
