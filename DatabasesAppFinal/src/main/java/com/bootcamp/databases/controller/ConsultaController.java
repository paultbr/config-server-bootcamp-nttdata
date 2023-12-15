package com.bootcamp.databases.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.databases.model.Consulta;
import com.bootcamp.databases.service.ConsultaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
	
private static final Logger logger = Logger.getLogger(ConsultaController.class);
	
	@Autowired
	private ConsultaService service;
	
	@PostMapping("/nuevo")
	public ResponseEntity<Consulta> registrar(@RequestBody String datos) {
		try {
			Consulta consulta=service.registrar(datos);
			return ResponseEntity.ok(consulta);
		} catch (Exception e) {
			logger.error("No se pudo registrar la consulta");
			logger.debug(e);
			return ResponseEntity.badRequest().body(new Consulta());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Consulta> actualizar(@PathVariable("id") int id, @RequestBody String datos) throws Exception {
		try {
			Consulta consulta=service.modificar(id,datos);
			return ResponseEntity.ok(consulta);
		} catch (Exception e) {
			logger.error("No se pudo actualizar");
			logger.debug(e);
			return ResponseEntity.badRequest().body(new Consulta());
		}
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Consulta> buscar(@RequestParam("id") int id) throws Exception {
		return ResponseEntity.ok(service.buscar(id));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Consulta>> listar() throws Exception {
		return ResponseEntity.ok(service.listarTodos());
	}

}
