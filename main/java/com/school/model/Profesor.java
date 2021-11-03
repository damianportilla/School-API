package com.school.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Profesor extends Persona implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Profesor;

	@ManyToMany
	@JsonManagedReference
	private Set<Curso> cursodictado ;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "profesor")
	private Set<Profesor_y_RRSS> redesSocialProfesor;

}
