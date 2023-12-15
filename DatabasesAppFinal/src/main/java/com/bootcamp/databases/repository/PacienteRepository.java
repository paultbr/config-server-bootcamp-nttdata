package com.bootcamp.databases.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.bootcamp.databases.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
