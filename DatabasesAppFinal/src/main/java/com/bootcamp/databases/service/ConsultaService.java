package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.Consulta;

public interface ConsultaService {
	
    public Consulta registrar(String datos) throws Exception;
	
	public Consulta modificar(int id,String datos) throws Exception;
	
	public Consulta buscar(int id) throws Exception;
	
	public List<Consulta> listarTodos() throws Exception;
}
