package com.school.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.error.CustomError;
import com.school.model.Curso;
import com.school.repository.CursoRepository;

@RestController
@RequestMapping(value = "/v1/api")
public class CursoController {

	@Autowired
	CursoRepository cursoRepository;

	@GetMapping(value = "/cursos")
	public ResponseEntity<List<Curso>> getAllCursos(@RequestParam(value = "name", required = false) String name) {
		List<Curso> cursos = new ArrayList<>();

		if (name == null) {
			cursos = cursoRepository.findAllCursos();
			if (cursos.isEmpty()) {
				return new ResponseEntity(new CustomError("No existen cursos"),HttpStatus.CONFLICT);
			} else {
				return new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
			}
		}else {
		cursos = cursoRepository.findByName(name);
			if(cursos.size()>=1) {
				return new ResponseEntity<List<Curso>>(cursos,HttpStatus.OK);
			}else {				
				return new ResponseEntity(new CustomError("No existen cursos"), HttpStatus.CONFLICT);
			}
		}
	}

}
