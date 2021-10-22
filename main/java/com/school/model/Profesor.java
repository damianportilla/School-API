package com.school.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profesor extends Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProfesor;

	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(name="ProfesoCursor", joinColumns = {@JoinColumn(name="idProfesor")}, inverseJoinColumns = {@JoinColumn(name="idCurso")})
	private Set<Curso> cursos = new HashSet<>();
	
}
