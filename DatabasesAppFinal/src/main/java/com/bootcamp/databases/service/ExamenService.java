package com.bootcamp.databases.service;
import java.util.List;

import com.bootcamp.databases.model.Examen;
import com.bootcamp.databases.model.Paciente;

public interface ExamenService {
	
	public void registrar(Examen p) throws Exception;
	public void modificar(Examen p) throws Exception;
	
    public Examen buscar(int id) throws Exception;
	public List<Examen> listarTodos() throws Exception;

}
