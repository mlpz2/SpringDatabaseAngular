package com.mlpz.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mlpz.spring.entities.Curso;
import com.mlpz.spring.services.CursoService;

@RestController
@RequestMapping("/api/curso")
@CrossOrigin(origins = "http://localhost:4200")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/")
	public ResponseEntity<List<Curso>> findAll(){
		List<Curso> cursos = cursoService.getAll();
		return new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Curso> findById(@PathVariable("id") int id) {
		Curso curso = cursoService.getById(id);
		return new ResponseEntity<Curso>(curso, HttpStatus.OK);
	}
	
	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<Curso> findByName(@PathVariable("nombre") String nombre) {
		Curso curso = cursoService.getByName(nombre);
		return new ResponseEntity<Curso>(curso, HttpStatus.OK);
	}
	
}
