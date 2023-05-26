package com.mlpz.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.mlpz.spring.entities.Curso;
import com.mlpz.spring.repositories.CursoRepository;

@Service
@Transactional
public class CursoService {

	private final CursoRepository cursoRepository;

	public CursoService(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}

	public List<Curso> getAll(){
		return cursoRepository.findAll();
	}
	
	public Curso getById(int id) {
		return cursoRepository.findById(id).get();
	}
	
	public Curso getByName(String nombre) {
		return cursoRepository.findByNombre(nombre);
	}
	
}
