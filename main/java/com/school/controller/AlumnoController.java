package com.school.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.school.error.CustomError;
import com.school.model.Alumno;
import com.school.service.AlumnoService;

@RestController
@RequestMapping(value = "/v1/api/alumnos")
public class AlumnoController {

	@Autowired
	AlumnoService alumnoService;

	// busqueda de todos los alumnos o por nombre con param
	@GetMapping
	public ResponseEntity<List<Alumno>> getAlumnos(@RequestParam(value = "name", required = false) String name) {

		List<Alumno> alumnos = new ArrayList<>();

		if (name == null) {
			alumnos = alumnoService.getAll();
			if (alumnos.isEmpty()) {
				return new ResponseEntity(new CustomError("No existen alumnos"), HttpStatus.CONFLICT);
			}
			return new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.OK);
		} else {
			alumnos = alumnoService.getByName(name);
			if (alumnos.size() >= 1) {
				return new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.OK);
			} else {
				return new ResponseEntity(new CustomError("No existe el alumno solicitado"), HttpStatus.OK);
			}
		}
	}

	// Post
	@PostMapping
	public ResponseEntity<Alumno> addAlumno(@RequestBody Alumno alumno, UriComponentsBuilder uriComponentsBuilder) {
		if (alumno.getNombre().equals(null)) {
			return new ResponseEntity(new CustomError("El campo nombre no puede estar vacio"), HttpStatus.CONFLICT);
		}
		
		alumnoService.create(alumno);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				uriComponentsBuilder.path("/v1/alumnos/{id}").buildAndExpand(alumno.getId_Alumno()).toUri());
		return new ResponseEntity<Alumno>(alumno, HttpStatus.CREATED);
//
	}

	// Ver un registro con por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Alumno> getAlumnoById(@PathVariable(name = "id") Long idAlumno) {
		if (idAlumno == null || idAlumno <= 0) {
			return new ResponseEntity(new CustomError("No se ingreso un id de alumno valido"), HttpStatus.CONFLICT);
		}
		if (idAlumno != null) {
			Alumno alumno = alumnoService.getById(idAlumno);
			if (alumno == null) {
				return new ResponseEntity(new CustomError("No se ingreso un id de alumno valido"), HttpStatus.CONFLICT);
			} else {
				return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
			}
		}
		return null;
	}

	// Actualizar un registro
	@PutMapping(value = "/{id}")
	public ResponseEntity<Alumno> patchAlumno(@PathVariable(name = "id") Long idAlumno, 
			@RequestBody Alumno alumno) {
		if (idAlumno == null || idAlumno <= 0) {
			return new ResponseEntity(new CustomError("No se ingreso un id de alumno valido"), HttpStatus.CONFLICT);
		}
		Alumno alumnoAux = alumnoService.getById(idAlumno);

		if (alumnoAux == null) {
			return new ResponseEntity(new CustomError("No existe el alumno"), HttpStatus.CONFLICT);
		}

		alumnoAux=Alumno.builder()
		.nombre(alumno.getNombre())
		.dni(alumno.getDni())
		.domicilio(alumno.getDomicilio())
		.email(alumno.getEmail())
		.id_Alumno(idAlumno)
		.build();

		alumnoService.update(alumnoAux);
		
		return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
	}
	
	
}
