package com.bootcamp.databases.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.bootcamp.databases.model.DetalleConsulta;

public interface DetalleConsultaRepository extends MongoRepository<DetalleConsulta, Integer>{
	
	//List<DetalleConsulta> busquedaId(int id);

}
