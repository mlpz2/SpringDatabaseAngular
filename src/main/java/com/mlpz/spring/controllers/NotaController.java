package com.mlpz.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mlpz.spring.services.NotaService;
import com.mlpz.spring.dto.Message;
import com.mlpz.spring.entities.Asignatura;
import com.mlpz.spring.entities.Curso;
import com.mlpz.spring.entities.Nota;
import com.mlpz.spring.entities.Usuario;

@RestController
@RequestMapping("/api/nota")
@CrossOrigin(origins = "http://localhost:4200")
public class NotaController {

	@Autowired
	private NotaService notaService;

	@GetMapping("/")
	public ResponseEntity<List<Nota>> findNotas(@RequestParam(required = false) String dniUsuario,
			@RequestParam(required = false) String nombreCurso, @RequestParam(required = false) String nombreAsignatura){
		List<Nota> notas = notaService.findNotas(dniUsuario, nombreCurso, nombreAsignatura);
		return new ResponseEntity<List<Nota>>(notas, HttpStatus.OK);
	}
	
	@GetMapping("/curso/{idC}/asignatura/{idA}")
	public ResponseEntity<List<Nota>> allNotasCursoAsignatura(@PathVariable("idC") int idC, @PathVariable("idA") int idA){
		List<Nota> notas = notaService.getByCursoAndAsignatura(new Curso(idC), new Asignatura(idA));
		return new ResponseEntity<List<Nota>>(notas, HttpStatus.OK);
	}
	
	@GetMapping("/curso/{idC}/alumno/{idA}")
	public ResponseEntity<List<Nota>> allNotasCursoAlumno(@PathVariable("idC") int idC, @PathVariable("idA") int idA){
		List<Nota> notas = notaService.getByCursoAndAlumno(new Curso(idC), new Usuario(idA));
		return new ResponseEntity<List<Nota>>(notas, HttpStatus.OK);
	}

	@GetMapping("/asignatura/{idA}/alumno/{idU}")
	public ResponseEntity<List<Nota>> allNotasAsignaturaAlumno(@PathVariable("idA") int idA, @PathVariable("idU") int idU){
		List<Nota> notas = notaService.getByAsignaturaAndAlumno(new Asignatura(idA), new Usuario(idU));
		return new ResponseEntity<List<Nota>>(notas, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<?> addNota(@RequestBody Nota nota) {
		notaService.save(nota);
		return new ResponseEntity<>(new Message("Nota saved successfully!"), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateNota(@PathVariable("id") int id, @RequestBody Nota nota) {
		if(!notaService.existsById(id)) {
			return new ResponseEntity<>(new Message("Nota does not exist!"), HttpStatus.NOT_FOUND);
		}
		nota.setId(id);
		notaService.save(nota);
		return new ResponseEntity<>(new Message("Nota updated successfully!"), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteNota(@PathVariable("id") int id) {
		if(!notaService.existsById(id)) {
			return new ResponseEntity<>(new Message("Nota does not exist!"), HttpStatus.NOT_FOUND);
		}
		notaService.deleteById(id);
		return new ResponseEntity<>(new Message("Nota deleted succesfully!"), HttpStatus.OK);
	}
}
