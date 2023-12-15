package com.bootcamp.databases.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "consultaExamen")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ConsultaExamen {
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConsultaExamen;*/
	
	@Column(name = "idExamen", nullable = false)
	private int idExamen;
	
	@Column(name = "idConsulta", nullable = false)
	private int idConsulta;

	public int getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	
	
}
