package com.bootcamp.databases.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.databases.model.AuxDetalleConsulta;
import com.bootcamp.databases.model.DetalleConsulta;
import com.bootcamp.databases.service.ConsultaService;
import com.bootcamp.databases.service.DetalleConsultaService;

@RestController
@RequestMapping("/detalle_consulta")
public class DetalleConsultaController {
	
private static final Logger logger = Logger.getLogger(DetalleConsultaController.class);
	
	@Autowired
	private DetalleConsultaService service;
	
	@PostMapping("/nuevo")
	public ResponseEntity<DetalleConsulta> registrar(@RequestBody DetalleConsulta detalle) {
		System.out.println(detalle);
		try {
			service.registrar(detalle);
			return ResponseEntity.ok(detalle);
		} catch (Exception e) {
			logger.error("No se pudo registrar el detalle");
			logger.debug(e);
			return ResponseEntity.badRequest().body(detalle);
		}
	}
	
	
	@PutMapping("/actualizar")
	public ResponseEntity<DetalleConsulta> actualizar(@RequestBody DetalleConsulta detalle) throws Exception {
		//service.registrar(consulta);
		return ResponseEntity.ok(detalle);
	}
	
	@GetMapping("/buscar")//la consulta del detalle se realiza buscando el "ID" de la consulta 
	public ResponseEntity<AuxDetalleConsulta> buscar(@RequestParam("id") int id) throws Exception {
		return ResponseEntity.ok(service.buscar(id));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<DetalleConsulta>> listar() throws Exception {
		return ResponseEntity.ok(service.listarTodos());
	}

}
