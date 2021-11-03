package com.school.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Alumno_y_RRSS {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_nick;

	private String nickname;

	@JsonManagedReference
	@OneToOne
	@JoinColumn(name = "id_RedSocial")
	private RedSocial redSocial;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_Alumno")
	private Alumno alumno;
	


}
