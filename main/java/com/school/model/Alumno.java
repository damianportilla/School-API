package com.school.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Alumno extends Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Alumno;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Alumno_Curso", joinColumns = { @JoinColumn(name = "id_Alumno") },inverseJoinColumns = {@JoinColumn(name = "id_Curso") })
	@ElementCollection
	private Set<Curso> cursos = new HashSet<>();

}
