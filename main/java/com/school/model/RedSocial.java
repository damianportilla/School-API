package com.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RedSocial {

	@Id
	private Long id_RedSocial;
	@Column
	private String nombre;
	@Column
	private String icono;

}
