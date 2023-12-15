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

import com.bootcamp.databases.model.Medico;
import com.bootcamp.databases.service.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {
	
	private static final Logger logger = Logger.getLogger(MedicoController.class);
	
	@Autowired
	private MedicoService service;
	
	@PostMapping("/nuevo")
	public ResponseEntity<Medico> registrar(@RequestBody Medico m) {
		logger.info("Registrar nuevo médico");
		try {
			service.registrar(m);
			return ResponseEntity.ok(m);
		} catch (Exception e) {
			logger.error("No se pudo registrar el médico");
			logger.debug(e);
			return ResponseEntity.badRequest().body(m);
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Medico> actualizar(@RequestBody Medico m) throws Exception {
		service.registrar(m);
		return ResponseEntity.ok(m);
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Medico> buscar(@RequestParam("id") int id) throws Exception {
		return ResponseEntity.ok(service.buscar(id));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Medico>> listar() throws Exception {
		return ResponseEntity.ok(service.listarTodos());
	}

}
