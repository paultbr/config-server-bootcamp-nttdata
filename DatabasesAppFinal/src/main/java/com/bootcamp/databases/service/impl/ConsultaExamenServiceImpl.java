package com.bootcamp.databases.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.ConsultaExamen;
import com.bootcamp.databases.repository.ConsultaExamenRepository;
import com.bootcamp.databases.service.ConsultaExamenService;

@Service
public class ConsultaExamenServiceImpl implements ConsultaExamenService {
	
	@Autowired
	private ConsultaExamenRepository repo;
	

	@Override
	public void registrar(ConsultaExamen ce) throws Exception {
		repo.save(ce);
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(ConsultaExamen ce) throws Exception {
		repo.save(ce);
		// TODO Auto-generated method stub

	}

	@Override
	public ConsultaExamen buscar(int id) throws Exception {
		Optional<ConsultaExamen> op = repo.findById(id);
		return op.isPresent() ? op.get() : new ConsultaExamen();
	}

	@Override
	public List<ConsultaExamen> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
