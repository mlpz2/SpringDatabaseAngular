package com.mlpz.spring.services;

import java.util.List;

import com.mlpz.spring.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.mlpz.spring.entities.Curso;

@Service
@Transactional
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
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
