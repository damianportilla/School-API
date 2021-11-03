package com.school.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Curso implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id_Curso;
	
	@NotNull
	private String nombre_Curso;

	private String descripcion;
	
    @ManyToMany(mappedBy = "cursos")
    @JsonBackReference
    private Set<Alumno> alumnos = new HashSet<>();
    
    @ManyToMany(mappedBy = "cursodictado")
    @JsonBackReference
    private Set<Profesor> profesores;
    
    
}
