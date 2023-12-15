package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.ConsultaExamen;

public interface ConsultaExamenService {
	public void registrar(ConsultaExamen ce) throws Exception;
	public void actualizar(ConsultaExamen ce) throws Exception;
	public ConsultaExamen buscar(int id) throws Exception;
	public List<ConsultaExamen> listarTodos() throws Exception;
	
}
