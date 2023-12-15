package com.bootcamp.databases.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.AuxDetalleConsulta;
import com.bootcamp.databases.model.Consulta;
import com.bootcamp.databases.model.DetalleConsulta;
import com.bootcamp.databases.repository.ConsultaRepository;
import com.bootcamp.databases.repository.DetalleConsultaRepository;
import com.bootcamp.databases.service.DetalleConsultaService;

@Service
public class DetalleConsultaServiceImpl implements DetalleConsultaService {
	
	@Autowired
	private DetalleConsultaRepository repo;
	
	@Autowired
	private ConsultaRepository repoConsulta;

	@Override
	public DetalleConsulta registrar(DetalleConsulta detalleconsulta) throws Exception {
		return repo.save(detalleconsulta);
	}

	@Override
	public void modificar(DetalleConsulta detalleconsulta) throws Exception {
		repo.save(detalleconsulta);

	}

	@Override
	public AuxDetalleConsulta buscar(int id) throws Exception {
		List<DetalleConsulta> lista=repo.findAll();
		List<DetalleConsulta> lista2=lista.stream().filter(x->id==x.getIdConsulta()).collect(Collectors.toList());
		
		System.out.println(lista2.get(0).getDiagnostico());
		Optional<Consulta> op = repoConsulta.findById(id);
		
		AuxDetalleConsulta respuesta=new AuxDetalleConsulta();
		if(op.isPresent()) {
			respuesta.setIdConsulta(lista2.get(0).getIdDetalle());
			respuesta.setDiagnostico(lista2.get(0).getDiagnostico());
			respuesta.setTratamiento(lista2.get(0).getTratamiento());
			respuesta.setConsulta(op.get());
			
			return respuesta;
		}
		return new AuxDetalleConsulta();
	}

	@Override
	public List<DetalleConsulta> listarTodos() throws Exception {
		return repo.findAll();
	}

}
