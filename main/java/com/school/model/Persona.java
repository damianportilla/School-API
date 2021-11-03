package com.school.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Persona implements Serializable{

	@NotBlank
	private String nombre;
	@NotBlank
	private String email;
	@NotBlank
	private String dni;
	@NotBlank
	private String domicilio;
		

}
