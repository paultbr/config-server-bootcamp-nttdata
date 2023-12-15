package com.bootcamp.databases.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.bootcamp.databases.model.Especialidad;
import com.bootcamp.databases.repository.EspecialidadRepository;
import com.bootcamp.databases.service.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {
	
	@Autowired
	private EspecialidadRepository repo;

	@Override
	public void registrar(Especialidad especialidad) throws Exception {
		repo.save(especialidad);

	}

	@Override
	public void modificar(Especialidad especialidad) throws Exception {
		repo.save(especialidad);

	}

	@Override
	public Especialidad buscar(int id) throws Exception {
		Optional<Especialidad> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Especialidad();
	}

	@Override
	public List<Especialidad> listarTodos() throws Exception {
		return repo.findAll();
	}

}
