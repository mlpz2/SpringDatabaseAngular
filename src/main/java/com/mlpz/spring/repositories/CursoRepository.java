package com.mlpz.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.mlpz.spring.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
	Curso findByNombre(@Param("nombre") String nombre);
}
