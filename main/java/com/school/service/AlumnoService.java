package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dao.AlumnoDAO;
import com.school.model.Alumno;
import com.school.model.Curso;
import com.school.repository.AlumnoRepository;

@Service
public class AlumnoService implements AlumnoDAO {

	@Autowired
	private AlumnoRepository alumnoRepository;

	@Override
	public void create(Alumno alumno) {
		alumnoRepository.insertWithEntityManager(alumno);
	}

	@Override
	public Alumno getById(Long id) {
		return alumnoRepository.getAlumnoByIdWithEntityManager(id);
	}

	@Override
	public List<Alumno> getAll() {
		return (List<Alumno>) alumnoRepository.findAllAlumnos();
	}

	@Override
	public void remove(Long id) {
		alumnoRepository.removeAlumnoById(id);
	}

	@Override
	public List<Alumno> getByName(String name) {
		return (List<Alumno>) alumnoRepository.findByName(name);
	}

	@Override
	public void update(Alumno alumno) {
		alumnoRepository.updateAlumno(alumno);
	}

}
