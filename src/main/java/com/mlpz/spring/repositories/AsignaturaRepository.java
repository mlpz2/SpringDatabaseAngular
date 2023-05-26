package com.mlpz.spring.repositories;

import com.mlpz.spring.entities.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {
	Asignatura findByNombre(String nombre);
}
