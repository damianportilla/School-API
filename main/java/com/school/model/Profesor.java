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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Profesor extends Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Profesor;

	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(name="Profesor_Curso", joinColumns = {@JoinColumn(name="id_Profesor")}, inverseJoinColumns = {@JoinColumn(name="id_Curso")})
	@JsonIgnore
	private Set<Curso> cursos = new HashSet<>();

	
	
	
}
