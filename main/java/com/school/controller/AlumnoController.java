package com.school.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.error.CustomError;
import com.school.model.Alumno;
import com.school.service.AlumnoService;

@RestController
@RequestMapping(value = "/v1/api")
public class AlumnoController {

	@Autowired
	AlumnoService alumnoService;

	@GetMapping("/alumnos")
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

	@GetMapping(value="/alumnos/{id}")
	public ResponseEntity<Alumno> getAlumnoById(@PathVariable (name="id") Long idAlumno){
		if(idAlumno == null || idAlumno <= 0) {
			return new ResponseEntity(new CustomError("No se ingreso un id de alumno valido"), HttpStatus.CONFLICT);
		}
		if(idAlumno != null) {
			Alumno alumno = alumnoService.getById(idAlumno);
			if(alumno == null) {
				return new ResponseEntity(new CustomError("No se ingreso un id de alumno valido"), HttpStatus.CONFLICT);
			}else {
				return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
			}
			
		}
		return null;
	}

	@PutMapping(value="/alumnos/{id}" )
	public ResponseEntity<Alumno> patchAlumno(
			@PathVariable (name="id") Long idAlumno, 
			@RequestBody Alumno alumno){
		if(idAlumno == null || idAlumno <= 0) {
			return new ResponseEntity(new CustomError("No se ingreso un id de alumno valido"), HttpStatus.CONFLICT);
		}
		Alumno alumnoAux = alumnoService.getById(idAlumno);
		
		if (alumnoAux == null) {
			return new ResponseEntity(new CustomError("No existe el alumno"), HttpStatus.NO_CONTENT);
		}
		
		alumnoAux.setNombre(alumno.getNombre());
		alumnoAux.setDni(alumno.getDni());
		alumnoAux.setDomicilio(alumno.getDomicilio());
		alumnoAux.setEmail(alumno.getEmail());
		
		alumnoService.update(alumnoAux);
		return new ResponseEntity<Alumno>(alumno,HttpStatus.OK);
	}
	}

