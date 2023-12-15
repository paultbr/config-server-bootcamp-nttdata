package com.bootcamp.databases.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.Consulta;
import com.bootcamp.databases.model.Especialidad;
import com.bootcamp.databases.model.Medico;
import com.bootcamp.databases.model.Paciente;
import com.bootcamp.databases.repository.ConsultaRepository;
import com.bootcamp.databases.repository.EspecialidadRepository;
import com.bootcamp.databases.repository.MedicoRepository;
import com.bootcamp.databases.repository.PacienteRepository;
import com.bootcamp.databases.service.ConsultaService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class ConsultaServiceImpl implements ConsultaService {
	
	@Autowired
	private ConsultaRepository repo;
	
	@Autowired
	private MedicoRepository repoMedico;
	
	@Autowired
	private EspecialidadRepository repoEspecialidad;
	
	@Autowired
	private PacienteRepository repoPaciente;
	
	
	@Override
	public Consulta registrar(String datos) throws Exception {
	    Consulta consulta=new Consulta();
		JsonParser jsonParser = new JsonParser();
		JsonObject json=jsonParser.parse(datos).getAsJsonObject();
		String fecha = json.getAsJsonPrimitive("fecha").getAsString();
		int idMedico = json.getAsJsonPrimitive("medico").getAsInt();
		int idEspecialidad = json.getAsJsonPrimitive("especialidad").getAsInt();
		int idPaciente = json.getAsJsonPrimitive("paciente").getAsInt();
		
		
		Medico medico=repoMedico.findById(idMedico).orElseThrow(()->new Exception("No hay datos"));
		Especialidad especialidad=repoEspecialidad.findById(idEspecialidad).orElseThrow(()->new Exception("No hay datos"));
		Paciente paciente=repoPaciente.findById(idPaciente).orElseThrow(()->new Exception("No hay datos"));
		
		
	    consulta.setFecha( LocalDate.parse(fecha));
	    consulta.setMedico(medico);
	    consulta.setEspecialidad(especialidad);
	    consulta.setPaciente(paciente);
	    
	    return repo.save(consulta);
	    
		
	}

	@Override
	public Consulta modificar(int id, String datos) throws Exception {
		
		JsonParser jsonParser = new JsonParser();
		JsonObject json=jsonParser.parse(datos).getAsJsonObject();
		String fecha = json.getAsJsonPrimitive("fecha").getAsString();
		int idMedico = json.getAsJsonPrimitive("medico").getAsInt();
		int idEspecialidad = json.getAsJsonPrimitive("especialidad").getAsInt();
		int idPaciente = json.getAsJsonPrimitive("paciente").getAsInt();
		
		
		Medico medico=repoMedico.findById(idMedico).orElseThrow(()->new Exception("No hay datos"));
		Especialidad especialidad=repoEspecialidad.findById(idEspecialidad).orElseThrow(()->new Exception("No hay datos"));
		Paciente paciente=repoPaciente.findById(idPaciente).orElseThrow(()->new Exception("No hay datos"));
		
		System.out.print(medico.getApellidos());
		Consulta consulta=repo.findById(id).orElseThrow(()->new Exception("No hay datos"));
		System.out.print(consulta.getFecha());
		
	    consulta.setFecha( LocalDate.parse(fecha));
	    consulta.setMedico(medico);
	    consulta.setEspecialidad(especialidad);
	    consulta.setPaciente(paciente);
	    
	    return repo.save(consulta);

	}

	@Override
	public Consulta buscar(int id) throws Exception {
		Optional<Consulta> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Consulta();
	}

	@Override
	public List<Consulta> listarTodos() throws Exception {
		return repo.findAll();
	}

}
