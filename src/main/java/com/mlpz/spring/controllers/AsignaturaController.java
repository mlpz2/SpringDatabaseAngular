package com.mlpz.spring.controllers;

import java.util.List;

import com.mlpz.spring.entities.Asignatura;
import com.mlpz.spring.services.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asignatura")
@CrossOrigin(origins = "http://localhost:4200")
public class AsignaturaController {
	
	private final AsignaturaService asignaturaService;

	public AsignaturaController(AsignaturaService asignaturaService) {
		this.asignaturaService = asignaturaService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Asignatura>> findAll(){
		List<Asignatura> asignaturas = asignaturaService.findAll();
		return new ResponseEntity<List<Asignatura>>(asignaturas, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Asignatura> findById(@PathVariable("id") int id) {
		Asignatura asignatura = asignaturaService.getById(id);
		return new ResponseEntity<Asignatura>(asignatura, HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Asignatura> findByNombre(@PathVariable("name") String nombre){
		Asignatura asignatura = asignaturaService.getByName(nombre);
		return new ResponseEntity<Asignatura>(asignatura, HttpStatus.OK);
	}
	
}
