package com.mlpz.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mlpz.spring.entities.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {
	Asignatura findByNombre(String nombre);
}
