package com.bootcamp.databases.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "detalleConsulta")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetalleConsulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalle;
	
	@Column(name = "diagnostico", nullable = false, length = 100)
	private String diagnostico;
	@Column(name = "tratamiento", nullable = false, length = 150)
	private String tratamiento;
	@Column(name = "idConsulta", nullable = false, length = 8, unique = true)
	private int idConsulta;
	public int getIdDetalle() {
		return idDetalle;
	}
	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	
	
}
