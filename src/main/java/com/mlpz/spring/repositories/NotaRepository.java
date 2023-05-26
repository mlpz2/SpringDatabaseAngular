package com.mlpz.spring.repositories;

import java.util.List;

import com.mlpz.spring.entities.Asignatura;
import com.mlpz.spring.entities.Curso;
import com.mlpz.spring.entities.Nota;
import com.mlpz.spring.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota,Integer> {
	List<Nota> findByCursoAndAlumno(Curso curso, Usuario alumno);
	List<Nota> findByCursoAndAsignatura(Curso curso, Asignatura asignatura);
	List<Nota> findByAsignaturaAndAlumno(Asignatura asignatura, Usuario alumno);
}
