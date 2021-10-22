package com.school.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
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
