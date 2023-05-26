package com.mlpz.spring.repositories;

import com.mlpz.spring.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
	Curso findByNombre(@Param("nombre") String nombre);
}
