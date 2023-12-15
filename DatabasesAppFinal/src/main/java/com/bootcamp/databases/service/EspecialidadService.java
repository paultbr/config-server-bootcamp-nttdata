package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.Especialidad;

public interface EspecialidadService {
    
	public void registrar(Especialidad especialidad) throws Exception;
	
	public void modificar(Especialidad especialidad) throws Exception;
	
	public Especialidad buscar(int id) throws Exception;
	
	public List<Especialidad> listarTodos() throws Exception;
}
