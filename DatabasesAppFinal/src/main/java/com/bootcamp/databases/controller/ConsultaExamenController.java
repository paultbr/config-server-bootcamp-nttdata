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

import com.bootcamp.databases.model.ConsultaExamen;
import com.bootcamp.databases.service.ConsultaExamenService;

@RestController
@RequestMapping("/consulta_examen")
public class ConsultaExamenController {
	
private static final Logger logger = Logger.getLogger(ConsultaExamenController.class);
	
	@Autowired
	private ConsultaExamenService service;
	
	@PostMapping("/nuevo")
	public ResponseEntity<ConsultaExamen> registrar(@RequestBody ConsultaExamen ce) {
		System.out.println(ce);
		try {
			service.registrar(ce);
			return ResponseEntity.ok(ce);
		} catch (Exception e) {
			logger.error("No se pudo registrar");
			logger.debug(e);
			return ResponseEntity.badRequest().body(ce);
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<ConsultaExamen> actualizar(@RequestBody ConsultaExamen ce) throws Exception {
		service.registrar(ce);
		return ResponseEntity.ok(ce);
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<ConsultaExamen> buscar(@RequestParam("id") int id) throws Exception {
		return ResponseEntity.ok(service.buscar(id));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<ConsultaExamen>> listar() throws Exception {
		return ResponseEntity.ok(service.listarTodos());
	}

}
