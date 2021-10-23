package com.school.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.school.model.Alumno;

@Repository
public class AlumnoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void insertWithEntityManager(Alumno alumno) {
		this.entityManager.persist(alumno);
	}

	@Transactional
	public Alumno getAlumnoByDniWithEntityManager(String dni) {
		return entityManager.find(Alumno.class, dni);
	}

	@Transactional
	public Alumno getAlumnoByIdWithEntityManager(Long id) {
		return entityManager.find(Alumno.class, id);
	}

	@Transactional
	public List<Alumno> findAllAlumnos() {
		return entityManager.createQuery("from Alumno").getResultList();
	}

	@Transactional
	public List<Alumno> findByName(String name) {
		return entityManager.createQuery
				("from Alumno where nombre = :name")
				.setParameter("name",name).getResultList();
	}
	
	@Transactional
	public void updateAlumno(Alumno alumno) {
		entityManager.merge(alumno);
	}

	@Transactional
	public void removeAlumnoById(Long id) {
		Alumno alumno = getAlumnoByIdWithEntityManager(id);
		try {
			entityManager.remove(alumno);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
