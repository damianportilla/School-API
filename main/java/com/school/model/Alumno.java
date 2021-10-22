package com.school.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alumno extends Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAlumno;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "AlumnoCurso", joinColumns = { @JoinColumn(name = "idAlumno") }, inverseJoinColumns = {
			@JoinColumn(name = "idCurso") })
	private Set<Curso> cursos = new HashSet<>();

}
