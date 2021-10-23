package com.school.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Persona {

	@Column
	private String nombre;
	@Column
	private String email;
	@Column
	private String dni;
	@Column
	private String domicilio;
	
	
}
