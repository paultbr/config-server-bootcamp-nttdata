package com.bootcamp.databases.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.Examen;
import com.bootcamp.databases.model.Paciente;
import com.bootcamp.databases.repository.ExamenRepository;
import com.bootcamp.databases.service.ExamenService;

@Service
public class ExamenServiceImpl implements ExamenService{
	
	@Autowired
	private ExamenRepository repoExamen;
	
	@Override
	public void registrar(Examen ex) throws Exception{
		repoExamen.save(ex);
	}
	
	@Override
	public void modificar(Examen ex) throws Exception{
		repoExamen.save(ex);
	}
	
	@Override
	public Examen buscar(int id) throws Exception {
		Optional<Examen> op = repoExamen.findById(id);
		return op.isPresent() ? op.get() : new Examen();
	}

	@Override
	public List<Examen> listarTodos() throws Exception {
		return repoExamen.findAll();
	}
	
	

}
