package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.AuxDetalleConsulta;
import com.bootcamp.databases.model.DetalleConsulta;

public interface DetalleConsultaService {
	
    public DetalleConsulta registrar(DetalleConsulta detalleconsulta) throws Exception;
	
	public void modificar(DetalleConsulta detalleconsulta) throws Exception;
	
	public AuxDetalleConsulta buscar(int id) throws Exception;
	
	public List<DetalleConsulta> listarTodos() throws Exception;

}
